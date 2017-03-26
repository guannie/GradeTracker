package com.gradetracker.se.gradetracker.data.repo;

/**
 * Created by User on 19-May-16.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.gradetracker.se.gradetracker.data.DatabaseManager;
import com.gradetracker.se.gradetracker.data.model.Semester;


public class SemesterRepo {

    private Semester semester;

    public SemesterRepo(){

        semester = new Semester();

    }

    public static String createTable(){
       return "CREATE TABLE " + Semester.TABLE + "("
                + Semester.KEY_Sem + " INTEGER PRIMARY KEY, "
                + Semester.KEY_Cpa + " TEXT, "
                + Semester.KEY_Gpa + " TEXT, "
                + Semester.KEY_CpaTarget + " TEXT )";
    }

    public int insert (Semester semester){
        int sem;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Semester.KEY_Sem, semester.getSem());
        values.put(Semester.KEY_Cpa, semester.getCpa());
        values.put(Semester.KEY_Gpa, semester.getGpa());
        values.put(Semester.KEY_CpaTarget, semester.getCpaTarget());

        // Inserting Row
        sem=(int)db.insert(Semester.TABLE,null,values);
        DatabaseManager.getInstance().closeDatabase();

        return sem;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Semester.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
