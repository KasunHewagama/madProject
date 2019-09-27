package com.example.madproject;

import java.util.Date;

public class HolidayData {
    private String Hname;
    private String Sdate;
    private String Edate;
    private String Hdiscription;

    public HolidayData() {
    }

    public String getHdiscription() {
        return Hdiscription;
    }

    public void setHdiscription(String hdiscription) {
        Hdiscription = hdiscription;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public String toString() {
        return this.Hname + "\n"+Sdate+"\n"+Edate+"\n"+Hdiscription;
    }

}
//abcd
//abcd
