package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Train {
    private String trainId;
    private String trainName;
    private String trainphone;
    private String trainno;
    private String trainFrom;
    private String trainTo;

    public Train(){
        //this constructor is required
    }


    public Train(String trainId, String trainName, String trainphone, String trainno, String trainFrom, String trainTo) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainphone = trainphone;
        this.trainno = trainno;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;

    }


    public String getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainphone() {
        return trainphone;
    }

    public String getTrainno() {
        return trainno;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }
}

