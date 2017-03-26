package com.gradetracker.se.gradetracker.PerformanceMonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import com.numetriclabz.numandroidcharts.MultiLineChart;

import com.gradetracker.se.gradetracker.R;

import java.util.ArrayList;
import java.util.List;

//import com.github.mikephil.charting.data.MultiLineChart;


public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MultiLineChart multiLineChart = (MultiLineChart) findViewById(R.id.chart);

        ArrayList<ChartData> cpa = new ArrayList<>();

        cpa.add(new ChartData((float) 3.6, 0)); //values.add(new ChartData(y,x));
        cpa.add(new ChartData((float) 3.0, 1));
        cpa.add(new ChartData((float) 3.5, 2));
        cpa.add(new ChartData((float) 3.69, 3));
        cpa.add(new ChartData((float) 3.7, 4));
        cpa.add(new ChartData((float) 3.99, 5));


        /*cpa.add(new ChartData((float) 3.6, 0));
        cpa.add(new Entry((float) 3.0, 1));
        cpa.add(new Entry((float) 3.5, 2));
        cpa.add(new Entry((float) 3.69, 3));
        cpa.add(new Entry((float) 3.7, 4));
        cpa.add(new Entry((float) 3.99, 5));
        */


        List<ChartData> target = new ArrayList<>();

        target.add(new ChartData(5f, 0)); //values.add(new ChartData(y,x));
        target.add(new ChartData(6f, 1));
        target.add(new ChartData(15f, 2));
        target.add(new ChartData(2f, 3));
        target.add(new ChartData(3f, 4));


        /*target.add(new Entry((float) 3.79, 0));
        target.add(new Entry((float) 3.5, 1));
        target.add(new Entry((float) 3.66, 2));
        target.add(new Entry((float) 3.0, 3));
        target.add(new Entry((float) 3.5, 4));
        target.add(new Entry((float) 3.78, 5));
        */

        List<ChartData> displaychart = new ArrayList<>();
        displaychart.add(new ChartData(cpa));
        displaychart.add(new ChartData(target));


        assert multiLineChart != null;
        multiLineChart.setData(displaychart);

        List<String> legends = new ArrayList<>();
        legends.add("GPA");
        legends.add("TARGET GPA");
        multiLineChart.setLegends(legends);

        List<String> h_lables = new ArrayList<>();
        h_lables.add("0.0");
        h_lables.add("SEM1");
        h_lables.add("SEM2");
        h_lables.add("SEM3");
        // h_lables.add("SEM4");
        // h_lables.add("SEM5");
        // h_lables.add("SEM6");
        // h_lables.add("SEM7");

        multiLineChart.setHorizontal_label(h_lables);

        multiLineChart.setCircleSize(15f);

        multiLineChart.setGesture(true);

    }
}
