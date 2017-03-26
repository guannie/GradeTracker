package com.gradetracker.se.gradetracker.TranscriptViewer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.stetho.Stetho;
import com.gradetracker.se.gradetracker.R;
import com.gradetracker.se.gradetracker.TargetAchiever.Receiver;
import com.gradetracker.se.gradetracker.data.model.Subject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by guanxuan95 on 5/28/2016.
 */
public class TranscriptViewer extends AppCompatActivity {
    public static final String TAG = TranscriptViewer.class.getSimpleName();
    List<Subject> subjectList = new ArrayList<Subject>();
    Button btn;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transcript);



        btn = (Button) findViewById(R.id.button3);
        //alarm();
        btn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    i = new Intent(TranscriptViewer.this, transcript2.class);
            }
        });
    }



}
