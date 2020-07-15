package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Bus {
    private String busId;
    private String busName;
    private String busphone;
    private String busno;
    private String busFrom;
    private String busTo;

    public Bus(){
        //this constructor is required
    }

    public Bus(String busId, String busName, String busphone, String busno, String busFrom,String busTo) {
        this.busId = busId;
        this.busName = busName;
        this.busphone=busphone;
        this.busno=busno;
        this.busFrom = busFrom;
        this.busTo = busTo;
    }


    public String getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getBusphone() {
        return busphone;
    }

    public String getBusno() {
        return busno;
    }

    public String getBusFrom() {
        return busFrom;
    }

    public String getBusTo() {
        return busTo;
    }


}

