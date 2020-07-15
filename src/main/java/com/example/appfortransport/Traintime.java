package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Traintime {

    private String trainId;
    private String trainstop1;
    private String trainstoptime1;
    private String trainstop2;
    private String trainstoptime2;
    private String trainstop3;
    private String trainstoptime3;

    public Traintime(){
        //this constructor is required
    }

    public Traintime(String trainId, String trainstop1, String trainstoptime1, String trainstop2, String trainstoptime2, String trainstop3, String trainstoptime3) {
        this.trainId = trainId;
        this.trainstop1 = trainstop1;
        this.trainstoptime1 = trainstoptime1;
        this.trainstop2 = trainstop2;
        this.trainstoptime2 = trainstoptime2;
        this.trainstop3 = trainstop3;
        this.trainstoptime3 = trainstoptime3;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getTrainstop1() {
        return trainstop1;
    }

    public String getTrainstoptime1() {
        return trainstoptime1;
    }

    public String getTrainstop2() {
        return trainstop2;
    }

    public String getTrainstoptime2() {
        return trainstoptime2;
    }

    public String getTrainstop3() {
        return trainstop3;
    }

    public String getTrainstoptime3() {
        return trainstoptime3;
    }
}
