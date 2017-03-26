package com.gradetracker.se.gradetracker.data.repo;

/**
 * Created by User on 19-May-16.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.gradetracker.se.gradetracker.data.DatabaseManager;
import com.gradetracker.se.gradetracker.data.model.Semester;
import com.gradetracker.se.gradetracker.data.model.Subject;


public class SubjectRepo {
    private Subject subject;

    public SubjectRepo(){
        subject = new Subject();
    }

    public static String createTable(){
        return "CREATE TABLE " + Subject.TABLE + "("
                + Subject.KEY_Code + " PRIMARY KEY ,"
                + Subject.KEY_Grade + " STRING ,"
                + Subject.KEY_Point + " DOUBLE ,"
                + Subject.KEY_CHour + " INTEGER ,"
                + Subject.KEY_Sem + " INTEGER)";
    }

    public int insert (Subject subject){
        int sem;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Subject.KEY_CHour, subject.getCHour());
        values.put(Subject.KEY_Code, subject.getCode());
        values.put(Subject.KEY_Sem, subject.getSem());
        values.put(Subject.KEY_Grade,subject.getGrade());
        values.put(Subject.KEY_Point,subject.getPoint());

        sem=(int)db.insert(Subject.TABLE,null,values);
        DatabaseManager.getInstance().closeDatabase();

        return sem;
    }

    public int remove (String code){
        int sem;
        String  []temp ={code};
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        sem= db.delete(Subject.TABLE, Subject.KEY_Code + "=?" ,temp );
        DatabaseManager.getInstance().closeDatabase();
        return sem;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Semester.TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

}
