package com.example.appfortransport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class dashboardpage extends AppCompatActivity {

    private ImageView busclick;
    private ImageView trainclick;
    private ImageView metroclick;
    private ImageView adminsclick;
    private ImageView aboutclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardpage);

        busclick = (ImageView) findViewById(R.id.modeofbus);
        trainclick = (ImageView) findViewById(R.id.modeoftrain);
        metroclick = (ImageView) findViewById(R.id.modeofmetro);
        adminsclick = (ImageView) findViewById(R.id.adminsonly);
        aboutclick = (ImageView) findViewById(R.id.aboutandhelp);
        busclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboardpage.this, buspage.class));
            }
        });

        trainclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboardpage.this, trainpage.class));
            }
        });

        metroclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboardpage.this, metropage.class));
            }
        });

        adminsclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboardpage.this, adminloginpage.class));
            }
        });

        aboutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboardpage.this, aboutandhelp.class));
            }
        });

    }

}