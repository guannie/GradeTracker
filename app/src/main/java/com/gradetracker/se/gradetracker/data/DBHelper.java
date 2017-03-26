package com.gradetracker.se.gradetracker.data;

/**
 * Created by Tan on 1/26/2016.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.gradetracker.se.gradetracker.app.App;
import com.gradetracker.se.gradetracker.data.model.Semester;
import com.gradetracker.se.gradetracker.data.model.Student;
import com.gradetracker.se.gradetracker.data.model.Subject;
import com.gradetracker.se.gradetracker.data.repo.SemesterRepo;
import com.gradetracker.se.gradetracker.data.repo.StudentRepo;
import com.gradetracker.se.gradetracker.data.repo.SubjectRepo;


public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =8;
    // Database Name
    private static final String DATABASE_NAME = "abc.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(SemesterRepo.createTable());
        db.execSQL(SubjectRepo.createTable());
        db.execSQL(StudentRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!

        db.execSQL("DROP TABLE IF EXISTS " + Semester.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Subject.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
        onCreate(db);
    }



}