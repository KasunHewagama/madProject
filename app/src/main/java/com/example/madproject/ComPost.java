package com.example.madproject;

public class ComPost {
    public ComPost(String pid, String title, String description) {
        Pid = pid;
        this.title = title;
        Description = description;
    }

    private String Pid;
    private String title;

    public ComPost() {

    }

    private String Description;

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
