package com.gradetracker.se.gradetracker.TargetAchiever;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gradetracker.se.gradetracker.R;

import java.util.Calendar;


public class target extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    Button btn;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Intent alarmIntent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target);

        context = this.getApplicationContext();
        final EditText target = (EditText) findViewById(R.id.target);
        final TextView result_Gpa = (TextView) findViewById(R.id.result_Gpa);
        Button calculate = (Button) findViewById(R.id.calculate);
        btn = (Button) findViewById(R.id.notify);
        //alarm();
        btn.setOnClickListener(
                new OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        /*Intent intent = new Intent();
                        PendingIntent pendingIntent = PendingIntent.getActivity(target.this,0,intent,0);
                        Notification notification = new Notification.Builder(target.this)
                                .setTicker("TickerTitle")
                                .setContentTitle("GRADE TRACKER")
                                .setContentText("SOFT REMINDER!! /nKeep track of your grade performance")
                                .setSmallIcon(R.drawable.ic_launcher)
                                .addAction(R.drawable.ic_launcher,"MY PERFORMANCE GRAPH",pendingIntent)
                                .setContentIntent(pendingIntent).getNotification();

                        notification.flags = Notification.FLAG_AUTO_CANCEL;
                        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(0,notification);*/
                        Intent intent = new Intent("com.gradetracker.se.gradetracker.TargetAchiever.Receiver");
                        sendBroadcast(intent);

                        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmIntent = new Intent(context, Receiver.class); // Receiver = broadcast receiver
                        pendingIntent = PendingIntent.getBroadcast(  target.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                        alarmIntent.setData((Uri.parse("1000"+System.currentTimeMillis())));
                        alarmManager.cancel(pendingIntent);

                        Calendar alarmStartTime = Calendar.getInstance();
                        Calendar now = Calendar.getInstance();
                        alarmStartTime.set(Calendar.HOUR_OF_DAY, 17);
                        alarmStartTime.set(Calendar.MINUTE, 25);
                        alarmStartTime.set(Calendar.SECOND, 0);
                        if (now.after(alarmStartTime)) {
                            Log.d("Hey","Added a day");
                            alarmStartTime.add(Calendar.DATE, 1);
                        }

                        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, now.getTimeInMillis(), 60*1000, pendingIntent);
                        Log.d("Alarm","Alarms set for once every minutes");

                    }
                }
        );

        assert calculate != null;
        calculate.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                final double CPA = 3.78;
                final int SEM = 4;
                double GPA = 0;
                double targetCpa;
                assert target != null;
                targetCpa = Double.parseDouble(target.getText().toString());

              /* if (targetCpa >= 4.00)
               {

               }else*/


                GPA = (SEM*targetCpa)-11.35;
                if (GPA > 4.00 ||GPA < 1.00){
                    showAlert(null);
                }
                else {
                    result_Gpa.setText(String.format("Your target GPA for next sem : %.2f", GPA));
                }

            }
        });


    }


    public void showAlert(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        AlertDialog alertDialog = myAlert.setMessage("YOUR TARGET IS INVALID")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        myAlert.show();
    }
}