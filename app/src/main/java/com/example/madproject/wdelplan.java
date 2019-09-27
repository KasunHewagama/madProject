package com.example.madproject;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class wdelplan  extends Application {
    public ArrayList<String> garrList = new ArrayList<>();
    public ArrayAdapter<String> garrAdp;
    public String gvalue_workoutName;
    public String gvalue_startingTime;


    public String getGvalue_workoutName() {
        return gvalue_workoutName;
    }

    public void setGvalue_workoutName(String gvalue_workoutName) {
        this.gvalue_workoutName = gvalue_workoutName;
    }

    public String getGvalue_startingTime() {
        return gvalue_startingTime;
    }

    public void setGvalue_startingTime(String gvalue_startingTime) {
        this.gvalue_startingTime = gvalue_startingTime;
    }



    ///////////////////////////
    public ArrayList<String> Harrlist=new ArrayList<>();
    public ArrayAdapter<String> Harradp;
    public String gvalue_hname;
    public String getGvalue_hdate;

    public String getValue_name() {
        return gvalue_hname;
    }

    public void setValue_name(String value_name) {
        this.gvalue_hname = value_name;
    }

    public String getGetGvalue_hdate() {
        return getGvalue_hdate;
    }

    public void setGetGvalue_hdate(String getGvalue_hdate) {
        this.getGvalue_hdate = getGvalue_hdate;
    }

    public ArrayList<String> getHarrlist() {
        return Harrlist;
    }

    public void setHarrlist(ArrayList<String> harrlist) {
        Harrlist = harrlist;
    }
}
