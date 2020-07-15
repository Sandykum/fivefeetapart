package com.example.appfortransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class buspage extends AppCompatActivity {


    ImageView busticketbooking,bustiming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buspage);

        busticketbooking=(ImageView) findViewById(R.id.eticketbooking);
        bustiming=(ImageView) findViewById(R.id.bustimings);

        busticketbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buspage.this, busticketbooking.class));
                finish();
            }
        });

        bustiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buspage.this, bustiming.class));
                finish();
            }
        });

    }
}