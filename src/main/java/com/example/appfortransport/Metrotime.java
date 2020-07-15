package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Metrotime {

    private String metroId;
    private String metrostop1;
    private String metrostoptime1;
    private String metrostop2;
    private String metrostoptime2;
    private String metrostop3;
    private String metrostoptime3;

    public Metrotime(){
        //this constructor is required
    }

    public Metrotime(String metroId, String metrostop1, String metrostoptime1, String metrostop2, String metrostoptime2, String metrostop3, String metrostoptime3) {
        this.metroId = metroId;
        this.metrostop1 = metrostop1;
        this.metrostoptime1 = metrostoptime1;
        this.metrostop2 = metrostop2;
        this.metrostoptime2 = metrostoptime2;
        this.metrostop3 = metrostop3;
        this.metrostoptime3 = metrostoptime3;
    }

    public String getMetroId() {
        return metroId;
    }

    public String getMetrostop1() {
        return metrostop1;
    }

    public String getMetrostoptime1() {
        return metrostoptime1;
    }

    public String getMetrostop2() {
        return metrostop2;
    }

    public String getMetrostoptime2() {
        return metrostoptime2;
    }

    public String getMetrostop3() {
        return metrostop3;
    }

    public String getMetrostoptime3() {
        return metrostoptime3;
    }
}
