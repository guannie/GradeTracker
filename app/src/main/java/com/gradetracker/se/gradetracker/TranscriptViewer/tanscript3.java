package com.gradetracker.se.gradetracker.TranscriptViewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gradetracker.se.gradetracker.R;

public class tanscript3 extends AppCompatActivity {
        Intent i;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanscript3);

        btn = (Button) findViewById(R.id.button3);
        //alarm();
        btn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        i = new Intent(tanscript3.this, transcript4.class);
                    }
                });
    }
}
