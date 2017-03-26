package com.gradetracker.se.gradetracker.PerformanceMonitor;

import android.app.Application;
import android.graphics.Path;
import android.graphics.Region;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class ChartData extends Application implements Serializable {

    private static final long serialVersionUID = 1L;

    private Float y_values, size, left, top, right, bottom, data, mValue, highest_value;
    private Float lowest_value,opening, closing;
    private int x_values ;
    private final Path mPath = new Path();
    private final Region mRegion = new Region();
    private String cordinate, pieLabel;
    List<ChartData> list;

    private JSONObject radarData;

    public ChartData(JSONObject data){
        this.radarData = data;
    }

    public ChartData(){
    }

    public ChartData(Float y_values, int x_values){
        this.y_values = y_values;
        this.x_values = x_values;
    }

    public ChartData(Float y_values, int x_values, Float size){
        this.y_values = y_values;
        this.x_values = x_values;
        this.size = size;
    }

    protected ChartData(Float left, Float top, Float right,Float bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    protected ChartData(Float y_axis, Integer x_axis, Float size,String cordinate){
        this.y_values = y_axis;
        this.x_values = x_axis;
        this.size = size;
        this.cordinate = cordinate;
    }

    public ChartData(String label, Float val){
        this.data = val;
        this.pieLabel = label;
    }

    protected ChartData(Float y_axis,Integer x_axis, String cordinate){
        this.y_values = y_axis;
        this.x_values = x_axis;
        this.cordinate = cordinate;

    }

    public ChartData(List<ChartData> list){
        this.list = list;
    }

    public ChartData(int x_values, Float highest_value, Float lowest_value, Float opening,Float closing){
        this.x_values = x_values;
        this.highest_value = highest_value;
        this.lowest_value = lowest_value;
        this.opening = opening;
        this.closing = closing;
    }

    public Float getY_values(){return y_values;}

    public int getX_values(){ return x_values;}

    public void setY_values(Float y_values){ this.y_values = y_values;}

    public  void setX_values(int x_values){ this.x_values = x_values;}

    public  void setSize(Float size){ this.size = size;}

    public Float getSize(){ return  size; }

    public  void setLeft(Float left){ this.left = left;}

    public Float getLeft(){ return  left; }

    public  void setTop(Float top){ this.top = top;}

    public Float getTop(){ return  top; }

    public  void setRight(Float right){ this.right = right;}

    public Float getRight(){ return  right; }

    public  void setBottom(Float bottom){ this.bottom = bottom;}

    public Float getBottom(){ return  bottom; }

    public  void setValue(Float data){ this.data = data;}

    public String getPieLabel(){
        return this.pieLabel;
    }

    public Float getValue(){ return  this.data; }

    public  void setCordinate(String cordinate){ this.cordinate = cordinate;}

    public String getCordinate(){ return  this.cordinate; }

    public Path getPath() {
        return mPath;
    }

    public Region getRegion() {
        return mRegion;
    }

    public float getSectorValue() {
        return mValue;
    }

    public void setSectorValue(float value) {
        mValue = value;
    }

    public JSONObject getRadarData(){
        return this.radarData;
    }

    public void setHighest_value(float highest_value){ this.highest_value = highest_value;}

    public Float getHighest_value(){ return highest_value;}

    public void setLowest_value(float lowest_value){ this.lowest_value = lowest_value;}

    public Float getLowest_value(){ return lowest_value;}

    public void setOpening(float opening){ this.opening = opening; }

    public Float getOpening(){ return opening;}

    public void setClosing(Float closing){ this.closing = closing;}

    public Float getClosing(){ return closing;}

    public void setList(List<ChartData> list){ this.list = list;}

    public List<ChartData> getList(){ return  list; }
}
