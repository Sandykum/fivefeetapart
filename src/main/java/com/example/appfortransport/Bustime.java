package com.example.appfortransport;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Bustime {

    private String busId;
    private String busstop1;
    private String busstoptime1;
    private String busstop2;
    private String busstoptime2;
    private String busstop3;
    private String busstoptime3;

    public Bustime(){
        //this constructor is required
    }

    public Bustime(String busId, String busstop1, String busstoptime1, String busstop2, String busstoptime2,String busstop3,String busstoptime3) {
        this.busId = busId;
        this.busstop1 = busstop1;
        this.busstoptime1=busstoptime1;
        this.busstop2=busstop2;
        this.busstoptime2 = busstoptime2;
        this.busstop3 = busstop3;
        this.busstoptime3=busstoptime3;
    }

    public String getBusId() {
        return busId;
    }

    public String getBusstop1() {
        return busstop1;
    }

    public String getBusstoptime1() {
        return busstoptime1;
    }

    public String getBusstop2() {
        return busstop2;
    }

    public String getBusstoptime2() {
        return busstoptime2;
    }

    public String getBusstop3() {
        return busstop3;
    }

    public String getBusstoptime3() {
        return busstoptime3;
    }
}
