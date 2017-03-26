package com.gradetracker.se.gradetracker.PerformanceMonitor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.gradetracker.se.gradetracker.GPACalculator.gpacalculator;
import com.gradetracker.se.gradetracker.MainActivity;
import com.gradetracker.se.gradetracker.R;
import com.gradetracker.se.gradetracker.TargetAchiever.target;

import java.util.ArrayList;

public class performance extends AppCompatActivity implements View.OnClickListener{

    public Button button ;
    public Intent i;
    public void init()
    {
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newPage = new Intent(performance.this, MainActivity.class);
                startActivity(newPage);

            }
        });

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performance);
        init();

        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        //LineChart target =

        // list entry
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry((float) 3.6, 0));
        entries.add(new Entry((float) 3.0, 1));
        entries.add(new Entry((float) 3.5, 2));
        entries.add(new Entry((float) 3.69, 3));
        entries.add(new Entry((float) 3.7, 4));
        entries.add(new Entry((float) 3.99, 5));

        LineDataSet dataset = new LineDataSet(entries, "Pointer # semester");

        //labels for every semester
        ArrayList<String> labels = new ArrayList<>();
        labels.add("SEM1");
        labels.add("SEM2");
        labels.add("SEM3");
        labels.add("SEM4");
        labels.add("SEM5");
        labels.add("SEM6");
        labels.add("SEM7");
        labels.add("SEM8");

        LineData data = new LineData(labels, dataset);

        //display data
        lineChart.setData(data);
        dataset.setColor(Color.MAGENTA);
        dataset.setCircleColor(Color.GRAY);
        dataset.setCircleSize(13f);
        //lineChart.setDescription("Description");  // set the description


        //CHART FOR TARGET
       /* LineChart target = (LineChart) findViewById(R.id.chart);
        ArrayList<Entry> targets = new ArrayList<>();
        targets.add(new Entry((float) 3.79, 0));
        targets.add(new Entry((float) 3.5, 1));
        targets.add(new Entry((float) 3.66, 2));
        targets.add(new Entry((float) 3.0, 3));
        targets.add(new Entry((float) 3.5, 4));
        targets.add(new Entry((float) 3.78, 5));
        */

     /*   LineDataSet dataTarget = new LineDataSet(targets, "Pointer # semester");

        //labels for every semester
        ArrayList<String> label_target = new ArrayList<>();
        label_target.add("SEM1");
        label_target.add("SEM2");
        label_target.add("SEM3");
        label_target.add("SEM4");
        label_target.add("SEM5");
        label_target.add("SEM6");
        label_target.add("SEM7");
        label_target.add("SEM8");

        LineData targetdata = new LineData(label_target, dataTarget);

        //display data
       target.setData(targetdata);
       */
    }

    public void onClick(View view) {
        Intent i;
        //This is the switch case which picks the button that was pressed by its id.
        switch (view.getId()) {
            case R.id.button:
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.button1:
                i = new Intent(this, performance2.class);
                startActivity(i);;
                break;
        }
    }

}
