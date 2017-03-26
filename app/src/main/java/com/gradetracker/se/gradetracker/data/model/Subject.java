package com.gradetracker.se.gradetracker.data.model;

/**
 * Created by User on 19-May-16.
 */
public class Subject {

    public static final String TAG = Subject.class.getSimpleName();
    public static final String TABLE = "Subject";

    public static final String KEY_Code = "Code";
    public static final String KEY_Grade = "Grade";
    public static final String KEY_CHour = "CHour";
    public static final String KEY_Point = "Point";
    public static final String KEY_Sem = "Sem";

    private String code;;
    private String grade;
    private Double point;
    private Integer cHour;
    private Integer sem;


    public String getCode(){
        return code;
    }

    public String getGrade(){return grade;}

    public Double getPoint(){
        return point;
    }

    public int getCHour(){
        return cHour;
    }

    public int getSem(){
        return sem;
    }



    public void setCode(String code){
        this.code=code;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }

    public void setPoint(double point){
        this.point=point;
    }

    public void setCHour(int cHour){
        this.cHour=cHour;
    }

    public void setSem(int sem){
        this.sem=sem;
    }

}
