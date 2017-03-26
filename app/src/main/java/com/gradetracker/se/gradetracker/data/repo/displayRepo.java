package com.gradetracker.se.gradetracker.data.repo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gradetracker.se.gradetracker.data.DatabaseManager;
import com.gradetracker.se.gradetracker.data.model.Semester;
import com.gradetracker.se.gradetracker.data.model.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanxuan95 on 5/29/2016.
 */
public class displayRepo {


    public List<Subject> getTranscript(int sem){
        Subject subject = new Subject();
        List<Subject> subjectList = new ArrayList<Subject>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Subject." + Subject.KEY_Code
                + ", Subject." + Subject.KEY_CHour
                + ", Subject." + Subject.KEY_Grade
                + ", Subject." + Subject.KEY_Point
                + " FROM " + Subject.TABLE
                + " WHERE Subject."+ Subject.KEY_Sem + " = " + sem + ") ";

        Log.d(Subject.TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                subject= new Subject();
                subject.setCode(cursor.getString(cursor.getColumnIndex(Subject.KEY_Code)));
                subject.setCHour(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Subject.KEY_CHour))));
                subject.setGrade(cursor.getString(cursor.getColumnIndex(Subject.KEY_Grade)));
                subject.setPoint(Double.parseDouble(cursor.getString(cursor.getColumnIndex(Subject.KEY_Point))));
                subjectList.add(subject);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return subjectList;

    }

    public List<Semester> semesters(int sem){
        Semester semesters = new Semester();
        List<Semester> semesterList = new ArrayList<Semester>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Semester." + Semester.KEY_Sem
                + ", Semester." + Semester.KEY_Gpa
                + ", Semester." + Semester.KEY_Cpa
                + ", Semester." + Semester.KEY_CpaTarget
                + " FROM " + Semester.TABLE + ") ";

        Log.d(Semester.TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                semesters= new Semester();
                semesters.setSem(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Semester.KEY_Sem))));
                semesters.setGpa(cursor.getString(cursor.getColumnIndex(Semester.KEY_Gpa)));
                semesters.setCpa(cursor.getString(cursor.getColumnIndex(Semester.KEY_Cpa)));
                semesters.setCpaTarget(cursor.getString(cursor.getColumnIndex(Semester.KEY_CpaTarget)));
                semesterList.add(semesters);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return semesterList;

    }
}
