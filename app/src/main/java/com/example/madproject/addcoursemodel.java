package com.example.madproject;

import android.app.TimePickerDialog;
public class addcoursemodel {
 private String subject;
 private String teacher;
 private String place;
 private String time;
 private String date;

    public addcoursemodel(String subject, String teacher, String place, String time, String date) {
        this.subject = subject;
        this.teacher = teacher;
        this.place = place;
        this.time = time;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public addcoursemodel() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return this.subject+" \n "+teacher+" \n "+place+" \n "+date;
    }
}

//pamod
//
