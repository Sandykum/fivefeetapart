package com.example.appfortransport;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class metropage extends AppCompatActivity {

    ImageView metroticketbooking,metrotiming;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metropage);

        metroticketbooking=(ImageView) findViewById(R.id.emetroticketbooking);
        metrotiming=(ImageView) findViewById(R.id.metrotimings);

        metroticketbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(metropage.this, metroticketbooking.class));
                finish();
            }
        });

        metrotiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(metropage.this, metrotiming.class));
                finish();
            }
        });

    }
}