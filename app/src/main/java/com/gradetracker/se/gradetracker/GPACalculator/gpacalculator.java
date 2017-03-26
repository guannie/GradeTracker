package com.gradetracker.se.gradetracker.GPACalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.gradetracker.se.gradetracker.R;

import java.util.ArrayList;
import java.util.List;

import at.markushi.ui.CircleButton;

/**
 * Created by guanxuan95 on 5/13/2016.
 */
public class gpacalculator extends AppCompatActivity implements View.OnClickListener{

    //Declaring global variable
    public static int sCount = 0; // variable which shows number of subjects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.gpacalculator);
        test();
        init();
    }


    public void test(){
        if (sCount!=0) sCount=0;
    }
    public void init(){

        CircleButton bAddSubject = (CircleButton) findViewById(R.id.bAddSubject);
        CircleButton bRemoveSubject = (CircleButton) findViewById(R.id.bRemoveSubject);
        CircleButton bCalculate = (CircleButton) findViewById(R.id.bCalculate);
        bAddSubject.setOnClickListener(this);
        bRemoveSubject.setOnClickListener(this);
        bCalculate.setOnClickListener(this);

        //Appending dynamic form
        for(int i = 0;i<5; i++) {
            addSubject();
        }
    }

    @Override
    //This is an onClick method that is called when one of the buttons is clicked.
    public void onClick(View view) {
        Intent i;
        //This is the switch case which picks the button that was pressed by its id.
        switch (view.getId()) {
            case R.id.bAddSubject:
                addSubject();
                break;
            case R.id.bRemoveSubject:
                removeSubject();
                break;
            case R.id.bCalculate:


                i = new Intent(this, calculatetranscript.class);
                //Create the bundle
                Bundle bundle = new Bundle();

                calCGPA(i, bundle);

                if(sCount == 0)
                    Toast.makeText(this, "There is no subject to calculate", Toast.LENGTH_SHORT).show();
                else{
                    //Add your data to bundle
                    bundle.putString("Count", Integer.toString(sCount));
                    //Add the bundle to the intent
                    i.putExtras(bundle);

                    //start that second activity
                    startActivity(i);
                }

                break;
        }
    }

    //Adding subject form
    public void addSubject(){

        //Declaration and assignment of widget
        TableLayout tl =(TableLayout) findViewById(R.id.tableLayout);

        TableRow tr = new TableRow(this);
        EditText et = new EditText(this);
        EditText et1 = new EditText(this);
        Spinner spinner = new Spinner(this);
        String[] items = new String[] { " A+ ", " A ", " A- "," B+ "," B "," B- "," C+ ", " C ", " D+ ", " D ", " F " };

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(dropDownAdapter);

        //Setting up ids for the dynamic variables
        tr.setId(1000 + sCount);
        et.setId(2000 + sCount);
        et1.setId(3000 + sCount);
        spinner.setId(4000 + sCount);

        //Appending child widget to a parent widget
        tr.addView(et);
        tr.addView(et1);
        tr.addView(spinner);
        tl.addView(tr);

        //Increase the total number of subjects
        sCount++;
    }

    //Removing subject form
    public void removeSubject(){
        TableLayout tl =(TableLayout) findViewById(R.id.tableLayout);
        tl.removeView(findViewById(999 + sCount));
        sCount--;
    }

    //points allocation for grade
    public double grading(String grade){
        double gradeValue = 0.00;
        if (grade.equals (" A+ "))
            gradeValue= 4.00;
        else if (grade.equals(" A "))
            gradeValue= 4.00;
        else if (grade.equals(" A- "))
            gradeValue= 3.67;
        else if (grade.equals(" B+ "))
            gradeValue = 3.33;
        else if (grade.equals(" B "))
            gradeValue = 3.00;
        else if (grade.equals (" B- "))
            gradeValue = 2.67;
        else if (grade.equals(" C+ "))
            gradeValue = 2.33;
        else if (grade.equals(" C "))
            gradeValue = 2.00;
        else if (grade.equals (" D+ "))
            gradeValue = 1.33;
        else if (grade.equals (" D "))
            gradeValue = 1.00;
        else if (grade.equals (" F "))
            gradeValue = 0;
        else
            gradeValue = 0;

        return gradeValue;
    }

    //Calculate CGPA
    public void calCGPA(Intent passValue, Bundle bundle) {

        int temp = sCount;

        String tempCode = new String();
        Integer tempCredit = new Integer(0);
        Double tempValue =new Double(0);
        Double tempGPA = new Double(0);
        String tempCode2 = new String();
        Integer tempCredit2 = new Integer(0);
        Double tempValue2 =new Double(0);
        Double tempGPA2 = new Double(0);
        double totalPoint=0.0, totalCredit = 0.0, totalPoint2=0.0, totalCredit2 = 0.0;

        for (int i = 0; i < sCount; i++) {
            try {
                EditText et = (EditText) findViewById(2000 + i);
                EditText et1 = (EditText) findViewById(3000 + i);
                tempCode = et.getText().toString();
                tempCredit = (Integer.parseInt(et1.getText().toString()));

                Spinner spinner = (Spinner) findViewById(4000 + i);
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

                tempValue2 =tempValue;
                tempValue = grading(String.valueOf(spinner.getSelectedItem()));

                bundle.putString("Code" + i, et.getText().toString());
                bundle.putString("Credit" + i, et1.getText().toString());
                bundle.putString("Grade" + i, String.valueOf(spinner.getSelectedItem()));
                bundle.putString("Point" + i, Double.toString(grading(String.valueOf(spinner.getSelectedItem()))));
                tempGPA2 =tempGPA;
                tempGPA = tempValue * tempCredit;
                totalPoint2 =totalPoint;
                totalPoint += tempGPA;
                totalCredit2 = totalCredit;
                totalCredit += tempCredit;
                temp--;
            }
            catch(NullPointerException ex)
            {
                i= sCount;
                sCount--;
                tempValue = tempValue2;
                tempGPA = tempGPA2;
                totalPoint = totalPoint2;
                totalCredit = totalCredit2;

            }
        }


        Double GPA = (totalPoint/totalCredit);

        bundle.putString("Result",String.format("%.2f", GPA));

        //For testing of CGPA
        /*Context context = getApplicationContext();
        CharSequence text = "Your CGPA is " + (totalPoint/totalCredit);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        */
    }
}
