package com.gradetracker.se.gradetracker.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Student {
    public static final String TAG = Student.class.getSimpleName();
    public static final String TABLE = "Student";

    // Labels Table Columns names
    public static final String KEY_ID = "ID";
    public static final String KEY_Name = "Name";

    private String ID ;
    private String name;

    public String getStudentId() {
        return ID;
    }

    public void setStudentId(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
