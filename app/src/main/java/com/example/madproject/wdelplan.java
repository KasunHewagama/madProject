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
}
