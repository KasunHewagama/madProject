package com.example.madproject;

public class newaddexammodel {
    private String exam;
    private String subject;
    private String place;
    private String date;

    public newaddexammodel() {
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return this.exam+" \n "+subject+"\n  "+place+" \n "+date;
    }
}
