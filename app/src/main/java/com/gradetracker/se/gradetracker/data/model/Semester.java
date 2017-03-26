package com.gradetracker.se.gradetracker.data.model;

/**
 * Created by User on 19-May-16.
 */
public class Semester {

    public static final String TAG = Semester.class.getSimpleName();
    public static final String TABLE = "Semester";

    // Labels Table Columns names
    public static final String KEY_Sem = "Sem";
    public static final String KEY_Gpa = "Gpa";
    public static final String KEY_Cpa = "Cpa";
    public static final String KEY_CpaTarget = "CpaTarget";

    private Integer sem;
    private String gpa;
    private String cpa;
    private String cpaTarget;


    public Integer getSem(){
        return sem;
    }

    public String getGpa(){
        return gpa;
    }

    public String getCpa(){
        return cpa;
    }

    public String getCpaTarget(){
        return cpaTarget;
    }

    public void setSem(Integer sem){
        this.sem=sem;
    }

    public void setGpa(String gpa){
        this.gpa=gpa;
    }

    public void setCpa(String cpa){
        this.cpa=cpa;
    }

    public void setCpaTarget(String cpaTarget){
        this.cpaTarget=cpaTarget;
    }

}


