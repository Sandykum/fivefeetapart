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

public class metroticketbookinglist extends AppCompatActivity {

    List<Metro> metros;
    DatabaseReference databaseMetros;
    public ListView listViewMetros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metroticketbookinglist);

        databaseMetros = FirebaseDatabase.getInstance().getReference("metros");
        metros = new ArrayList<>();
        listViewMetros = (ListView) findViewById(R.id.listViewMetros);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseMetros.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                metros.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Metro metrono = postSnapshot.getValue(Metro.class);
                    //adding artist to the list
                    metros.add(metrono);
                }

                //creating adapter
                Metrolist MetroAdapter = new Metrolist(metroticketbookinglist.this, metros);
                //attaching adapter to the listview
                listViewMetros.setAdapter(MetroAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}