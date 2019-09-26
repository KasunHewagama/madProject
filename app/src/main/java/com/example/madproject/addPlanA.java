package com.example.madproject;

import android.app.TimePickerDialog;

import java.util.Date;

public class addPlanA {
    private String workoutName;
    private String startingTime;
    private String endingTime;
    private int distance;
//    private int avg;

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

//    public int getAvg() {
//        return avg;
//    }
//
//    public void setAvg(int avg) {
//        this.avg = avg;
//    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public addPlanA(String workoutName, String startingTime, String endingTime, int distance/*,int age*/) {
        this.workoutName = workoutName;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.distance = distance;
//        this.avg = getDistance()/ (getEndingTime()-getEndingTime());
    }

    public addPlanA() {
    }

    public String toString(){
        return this.workoutName + " - "+startingTime+" - "+endingTime+" - "+distance/*+" - "+avg*/;
    }

}
