package com.example.madproject;

public class ComPost {
    public ComPost(String pid, String title, String description) {

        this.title = title;
        Description = description;
    }

    private String Pid;
    private String title;
    private String Description;

    public ComPost() {

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

    public String toString(){
        return title+"\n"+Description+"\n";
    }
}
