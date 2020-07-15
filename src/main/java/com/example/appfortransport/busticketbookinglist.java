package com.example.appfortransport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class busticketbookinglist extends AppCompatActivity {

    List<Bus> buses;
    DatabaseReference databaseBus;
    public ListView listViewBuses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busticketbookinglist);

        databaseBus = FirebaseDatabase.getInstance().getReference("buses");
        buses = new ArrayList<>();
        listViewBuses = (ListView) findViewById(R.id.listViewBuses);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseBus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                buses.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Bus busno = postSnapshot.getValue(Bus.class);
                    //adding artist to the list
                    buses.add(busno);
                }

                //creating adapter
                Buslist BusAdapter = new Buslist(busticketbookinglist.this, buses);
                //attaching adapter to the listview
                listViewBuses.setAdapter(BusAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}