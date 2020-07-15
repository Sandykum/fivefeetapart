package com.example.appfortransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class aboutandhelp extends AppCompatActivity {

    ImageView aboutus, covidrule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutandhelp);

        aboutus = (ImageView) findViewById(R.id.aboutpage);
        covidrule = (ImageView) findViewById(R.id.covidrules);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(aboutandhelp.this, aboutuspage.class));
                finish();
            }
        });

        covidrule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(aboutandhelp.this,covidrules.class));
                finish();
            }
        });

    }
}