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

public class traintickbookinglist extends AppCompatActivity {

    List<Train> trains;
    DatabaseReference databaseTrain;
    public ListView listViewTrains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traintickbookinglist);

        databaseTrain = FirebaseDatabase.getInstance().getReference("trains");
        trains = new ArrayList<>();
        listViewTrains = (ListView) findViewById(R.id.listViewTrains);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseTrain.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                trains.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Train trainno = postSnapshot.getValue(Train.class);
                    //adding artist to the list
                    trains.add(trainno);
                }

                //creating adapter
                Trainlist TrainAdapter = new Trainlist(traintickbookinglist.this, trains);
                //attaching adapter to the listview
                listViewTrains.setAdapter(TrainAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}