package com.gradetracker.se.gradetracker.GPACalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.gradetracker.se.gradetracker.R;
import com.gradetracker.se.gradetracker.data.model.Subject;
import com.gradetracker.se.gradetracker.data.repo.SubjectRepo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanxuan95 on 5/12/2016.
 */
public class calculatetranscript extends AppCompatActivity implements View.OnClickListener {

    public static Boolean status = false;
    public static Boolean status2 = false;
    public static int sCount = 0;
    public static int sem = 0;
    List<String> Code = new ArrayList<String>();
    List<String> Credit = new ArrayList<String>();
    List<String> Grade = new ArrayList<String>();
    List<String> Point = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.calculatetranscript);
        test();
        init();
        display();
    }

    public void test(){
        if (status!=false) status=false;
        if (status2!=false) status2=false;
        //if (sem!=0) sem=0;
    }
    public void init(){

        Button button = (Button) findViewById(R.id.button);
        Button bSave = (Button) findViewById(R.id.bSave);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        button.setOnClickListener(this);
        bSave.setOnClickListener(this);

        spinner.setVisibility(View.INVISIBLE);

    }
    public void display(){

        String GPA;

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        try {
            // do stuff
           bundle.getString("Code0");


        } catch (Exception e){
            e.printStackTrace();
            // ignore error otherwise, if we can safely do so.
            Intent i = new Intent(this, calculatetranscript.class);
            startActivity(i);
        }

        String tempCode="", tempGrade="", tempCredit ="",tempPoint="";

        TextView tv5 = (TextView) findViewById(R.id.textView5);
        TableLayout tl =(TableLayout) findViewById(R.id.tableLayout);


        //Extract the data…
        GPA = bundle.getString("Result");
        sCount = Integer.parseInt(bundle.getString("Count"));

        for(int i = 0; i < sCount; i++) {

            TableRow tr = new TableRow(this);
            TextView tv = new  TextView(this);
            TextView tv1 = new  TextView(this);
            TextView tv2 = new  TextView(this);
            TextView tv3 = new  TextView(this);


            try {
                tempCode = bundle.getString("Code"+i);
                tempCredit = bundle.getString("Credit"+i);
                tempGrade = bundle.getString("Grade"+i);
                tempPoint = bundle.getString("Point"+i);

            } catch (Exception e){

                i= sCount;
                tempCode = "";
                tempCredit = "";
                tempGrade = "";
                tempPoint = "";
            }
            Code.add(tempCode);
            Credit.add(tempCredit);
            Grade.add(tempGrade);
            Point.add(tempPoint);


            tv.setText(tempCode);
            tv1.setText(tempCredit.toString());
            tv2.setText(tempGrade);
            tv3.setText(tempPoint.toString());

            tv.setGravity(Gravity.CENTER);
            tv1.setGravity(Gravity.CENTER);
            tv2.setGravity(Gravity.CENTER);
            tv3.setGravity(Gravity.CENTER);

            tr.addView(tv);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tl.addView(tr);


        }

        tv5.setText("GPA:   " + GPA);
       /* Context context = getApplicationContext();
        CharSequence text = "Your GPA is " + GPA;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/
    }

    @Override
    //This is an onClick method that is called when one of the buttons is clicked.
    public void onClick(View view) {
        Intent i;
        //This is the switch case which picks the button that was pressed by its id.
        switch (view.getId()) {
            case R.id.button:
                i = new Intent(this, gpacalculator.class);
                Bundle bundle = new Bundle();
                sCount=0;
                bundle.putString("Count", Integer.toString(sCount));
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.bSave:
                 if (status==false) show();
                 if(status2==false)   dropdown();
                if((status && status2)) {
                    insertData();
                    Toast.makeText(this, "Your transcript is recorded", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void show(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] { " - Semester - "," Semester 1 ", " Semester 2 ", " Semester 3 "," Semester 4 "," Semester 5 "," Semester 6 " };
        spinner.setVisibility(View.VISIBLE);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

        Toast.makeText(this, "Please choose which Semester to save in", Toast.LENGTH_SHORT).show();
        status = true;
    }

    public void dropdown(){

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        if(spinner.getSelectedItemPosition() == 0){
            status2 = false;
        }
        else {
            sem = (spinner.getSelectedItemPosition());
            status2 = true;
        }
    }


    private void  insertData(){

        for(int i = 0; i <Code.size(); i++) {
            SubjectRepo subjectRepo = new SubjectRepo();

            Subject subject = new Subject();
            subject.setCode(Code.get(i));
            subject.setCHour(Integer.parseInt(Credit.get(i)));
            subject.setSem(sem);
            subject.setGrade(Grade.get(i));
            subject.setPoint(Double.parseDouble(Point.get(i)));
            subjectRepo.insert(subject);
        }
    }
}
