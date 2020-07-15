package com.example.appfortransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class trainpage extends AppCompatActivity {

    ImageView trainticketbooking,traintiming;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainpage);

        trainticketbooking=(ImageView) findViewById(R.id.etrainticketbooking);
        traintiming=(ImageView) findViewById(R.id.traintimings);

        trainticketbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(trainpage.this, trainticketbooking.class));
                finish();
            }
        });

        traintiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(trainpage.this, traintiming.class));
                finish();
            }
        });
    }
}