package com.example.madproject;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class coursedeletmodal extends Application {

    public ArrayList<String> lv1 = new ArrayList<>();
    public ArrayAdapter<String> lv1dp;
    public String  coursevalue_name;
    public String  getCoursevalue_name;

    public ArrayList<String> getLv1() {
        return lv1;
    }

    public void setLv1(ArrayList<String> lv1) {
        this.lv1 = lv1;
    }

    public String getCoursevalue_name() {
        return coursevalue_name;
    }

    public void setCoursevalue_name(String coursevalue_name) {
        this.coursevalue_name = coursevalue_name;
    }

    public String getGetCoursevalue_name() {
        return getCoursevalue_name;
    }

    public void setGetCoursevalue_name(String getCoursevalue_name) {
        this.getCoursevalue_name = getCoursevalue_name;
    }
}
