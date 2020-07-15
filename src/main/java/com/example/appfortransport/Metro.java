package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Metro {
    private String metroId;
    private String metroName;
    private String metrophone;
    private String metrono;
    private String metroFrom;
    private String metroTo;

    public Metro(){
        //this constructor is required
    }

    public Metro(String metroId, String metroName,  String metrophone,  String metrono , String metroFrom,String metroTo) {
        this.metroId = metroId;
        this.metroName = metroName;
        this.metrophone = metrophone;
        this.metrono = metrono;
        this.metroFrom = metroFrom;
        this.metroTo = metroTo;
    }


    public String getMetroId() {
        return metroId;
    }

    public String getMetroName() {
        return metroName;
    }

    public String getMetrophone() {
        return metrophone;
    }

    public String getMetrono() {
        return metrono;
    }

    public String getMetroFrom() {
        return metroFrom;
    }

    public String getMetroTo() {
        return metroTo;
    }
}


