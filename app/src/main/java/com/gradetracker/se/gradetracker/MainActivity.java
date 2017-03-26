package com.gradetracker.se.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.gradetracker.se.gradetracker.GPACalculator.gpacalculator;
import com.gradetracker.se.gradetracker.PerformanceMonitor.performance;
import com.gradetracker.se.gradetracker.PerformanceMonitor.performance2;
import com.gradetracker.se.gradetracker.TargetAchiever.target;
import com.gradetracker.se.gradetracker.TranscriptViewer.TranscriptViewer;
import com.gradetracker.se.gradetracker.data.model.Semester;
import com.gradetracker.se.gradetracker.data.model.Student;
import com.gradetracker.se.gradetracker.data.model.Subject;
import com.gradetracker.se.gradetracker.data.repo.SemesterRepo;
import com.gradetracker.se.gradetracker.data.repo.StudentRepo;
import com.gradetracker.se.gradetracker.data.repo.SubjectRepo;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    /** Called when the activity is first created. */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Stetho.initializeWithDefaults(this);

        insertdata();
    }


    //This is an onClick method that is called when one of the buttons is clicked.
    public void onClick(View view) {
        Intent i;
        //This is the switch case which picks the button that was pressed by its id.
        switch (view.getId()) {
            case R.id.bGPACalculator:
                i = new Intent(MainActivity.this, gpacalculator.class);
                startActivity(i);
                break;
            case R.id.bViewTranscript:
                i = new Intent(MainActivity.this, TranscriptViewer.class);
                startActivity(i);
                break;
            case R.id.bSetTarget:
                i = new Intent(MainActivity.this, target.class);
                startActivity(i);
                break;
            case R.id.bViewPerformance:
                i = new Intent(MainActivity.this, performance2.class);
                startActivity(i);
                break;
        }
    }


    //This is a method to initialize all the variables.
    public void init() {

        //declaration for all the buttons
        ImageView bGPACalculator, bViewTransript, bSetTarget, bViewPerformance;

        bGPACalculator = (ImageView) findViewById(R.id.bGPACalculator);
        bViewTransript = (ImageView) findViewById(R.id.bViewTranscript);
        bSetTarget = (ImageView) findViewById(R.id.bSetTarget);
        bViewPerformance = (ImageView) findViewById(R.id.bViewPerformance);

        bGPACalculator.setOnClickListener(MainActivity.this);
        bViewTransript.setOnClickListener(MainActivity.this);
        bSetTarget.setOnClickListener(MainActivity.this);
        bViewPerformance.setOnClickListener(MainActivity.this);

    }

    private void  insertdata(){

        StudentRepo studentRepo = new StudentRepo();
        SemesterRepo semesterRepo = new SemesterRepo();
        SubjectRepo subjectRepo = new SubjectRepo();

        Student student = new Student();
        Semester semester = new Semester();
        Subject subject = new Subject();

        studentRepo.delete();
        semesterRepo.delete();
        subjectRepo.delete();

        student.setStudentId("A14CS0123");
        student.setName("Nurul Nadira");
        studentRepo.insert(student);

        subject.setCode("SCSB1233");
        subject.setCHour(3);
        subject.setSem(1);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSJ1233");
        subject.setCHour(3);
        subject.setSem(1);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSR1233");
        subject.setCHour(3);
        subject.setSem(1);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSV1233");
        subject.setCHour(3);
        subject.setSem(1);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        semester.setSem(1);
        semester.setGpa("4.00");
        semester.setCpa("4.00");
        semester.setCpaTarget("4.00");
        semesterRepo.insert(semester);

        subject.setCode("SCSB1253");
        subject.setCHour(3);
        subject.setSem(2);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSJ1253");
        subject.setCHour(3);
        subject.setSem(2);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSR1253");
        subject.setCHour(3);
        subject.setSem(2);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSV1253");
        subject.setCHour(3);
        subject.setSem(2);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        semester.setSem(2);
        semester.setGpa("4.00");
        semester.setCpa("4.00");
        semester.setCpaTarget("4.00");
        semesterRepo.insert(semester);

        subject.setCode("SCSB2233");
        subject.setCHour(3);
        subject.setSem(3);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSJ2233");
        subject.setCHour(3);
        subject.setSem(3);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSR2233");
        subject.setCHour(3);
        subject.setSem(3);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);

        subject.setCode("SCSV2233");
        subject.setCHour(3);
        subject.setSem(3);
        subject.setGrade("A+");
        subject.setPoint(4.00);
        subjectRepo.insert(subject);


        semester.setSem(3);
        semester.setGpa("4.00");
        semester.setCpa("4.00");
        semester.setCpaTarget("4.00");
        semesterRepo.insert(semester);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
