package com.gradetracker.se.gradetracker.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.gradetracker.se.gradetracker.data.DatabaseManager;
import com.gradetracker.se.gradetracker.data.model.Student;


/**
 * Created by Tan on 1/26/2016.
 */
public class StudentRepo  {

    private Student student;

    public StudentRepo(){

        student= new Student();

    }


    public static String createTable(){
        return "CREATE TABLE " + Student.TABLE  + "("
                + Student.KEY_ID  + " TEXT PRIMARY KEY  ,"
                + Student.KEY_Name + " TEXT )";
    }



    public void insert(Student student) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_ID, student.getStudentId());
        values.put(Student.KEY_Name, student.getName());

        // Inserting Row
        db.insert(Student.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Student.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }





}
