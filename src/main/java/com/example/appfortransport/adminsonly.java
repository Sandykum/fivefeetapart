package com.example.appfortransport;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class adminsonly extends AppCompatActivity {

    ImageView modeofbuslist,modeoftrainlist,modeofmetrolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsonly);

        modeofbuslist = (ImageView) findViewById(R.id.modeofbuslist);
        modeoftrainlist = (ImageView) findViewById(R.id.modeoftrainlist);
        modeofmetrolist = (ImageView) findViewById(R.id.modeofmetrolist);

        modeofbuslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminsonly.this, busticketbookinglist.class));
                finish();
            }
        });

        modeoftrainlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminsonly.this,traintickbookinglist.class));
                finish();
            }
        });

        modeofmetrolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminsonly.this, metroticketbookinglist.class));
                finish();
            }
        });

    }



}
