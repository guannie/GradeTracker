package com.gradetracker.se.gradetracker.PerformanceMonitor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.gradetracker.se.gradetracker.R;

import java.util.ArrayList;

/**
 * Created by guanxuan95 on 5/29/2016.
 */
public class performance2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performance2);
        BarChart chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        assert chart != null;
        chart.setData(data);
        chart.setDescription("GPA VS TARGET");
        chart.animateXY(1000, 1000);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry((float) 3.65, 0); // SEMESTER 1
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry((float) 3.79, 1); // SEMESTER 2
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry((float) 3.98, 2); // SEMESTER 3
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry((float) 2.5, 3); // SEMESTER 4
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry((float) 3.0, 4); // SEMESTER 5
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry((float) 3.45, 5); // SEMESTER 6
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry((float) 4.00, 5); // SEMESTER 7
        valueSet1.add(v1e7);
        BarEntry v1e8 = new BarEntry((float) 3.89, 5); // SEMESTER 8
        valueSet1.add(v1e8);

        ArrayList<BarEntry> target_value = new ArrayList<>();
        BarEntry v2e1 = new BarEntry((float) 3.65, 0); //SEMESTER 1
        target_value.add(v2e1);
        BarEntry v2e2 = new BarEntry((float) 2.5, 1); // SEMESTER 2
        target_value.add(v2e2);
        BarEntry v2e3 = new BarEntry((float) 2.45, 2); // SEMESTER 3
        target_value.add(v2e3);
        BarEntry v2e4 = new BarEntry((float) 2.99, 3); // SEMESTER 4
        target_value.add(v2e4);
        BarEntry v2e5 = new BarEntry((float) 2.44, 4); // SEMESTER 5
        target_value.add(v2e5);
        BarEntry v2e6 = new BarEntry((float) 2.35, 5); // SEMESTER 6
        target_value.add(v2e6);
        BarEntry v2e7 = new BarEntry((float) 2.35, 5); // SEMESTER 7
        target_value.add(v2e7);
        BarEntry v2e8 = new BarEntry((float) 2.35, 5); // SEMESTER 8
        target_value.add(v2e8);

        BarDataSet gpa = new BarDataSet(valueSet1, "GPA");
        gpa.setColor(Color.rgb(0, 155, 0));
        BarDataSet target = new BarDataSet(target_value, "TARGET");
        target.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(gpa);
        dataSets.add(target);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("SEM1");
        xAxis.add("SEM2");
        xAxis.add("SEM3");
        xAxis.add("SEM4");
        xAxis.add("SEM5");
        xAxis.add("SEM6");
        xAxis.add("SEM7");
        xAxis.add("SEM8");
        return xAxis;
    }
}
