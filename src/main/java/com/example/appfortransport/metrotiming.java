package com.example.appfortransport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class metrotiming extends AppCompatActivity {

    EditText editTextmetrostop1;
    EditText editTextmetrostoptime1;
    EditText editTextmetrostop2;
    EditText editTextmetrostoptime2;
    EditText editTextmetrostop3;
    EditText editTextmetrostoptime3;
    Button   buttonAddmetrotime;
    public ListView listViewMetrostime;
    List<Metrotime> metrostime;
    DatabaseReference databaseMetrotime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrotiming);

        databaseMetrotime = FirebaseDatabase.getInstance().getReference("busestime");
        listViewMetrostime = (ListView) findViewById(R.id.listViewMetrostime);

   /*     //getting views
        editTextmetrostop1 = (EditText) findViewById(R.id.editTextmetrostop1);
        editTextmetrostoptime1 = (EditText) findViewById(R.id.editTextmetrostoptime1);
        editTextmetrostop2 = (EditText) findViewById(R.id.editTextmetrostop2);
        editTextmetrostoptime2 = (EditText) findViewById(R.id.editTextmetrostoptime2);
        editTextmetrostop3 = (EditText) findViewById(R.id.editTextmetrostop3);
        editTextmetrostoptime3 = (EditText) findViewById(R.id.editTextmetrostoptime3);
        buttonAddmetrotime = (Button) findViewById(R.id.buttonAddmetrotime);
*/

        //list to store name of the booker
        metrostime = new ArrayList<>();

        //checking whether they can book the ticket

/*
        //adding an onclicklistener to button
        buttonAddmetrotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation

                addMetrotime();

            }
        });

    }


    private void addMetrotime() {
        //getting the values to save
        String metrostop1 = editTextmetrostop1.getText().toString().trim();
        String metrostoptime1 = editTextmetrostoptime1.getText().toString().trim();
        String metrostop2 = editTextmetrostop2.getText().toString().trim();
        String metrostoptime2 = editTextmetrostoptime2.getText().toString().trim();
        String metrostop3 = editTextmetrostop3.getText().toString().trim();
        String metrostoptime3 = editTextmetrostoptime3.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(metrostop1)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseMetrotime.push().getKey();

            //creating an name Object
            Metrotime metrotime = new Metrotime(id, metrostop1,metrostoptime1,metrostop2,metrostoptime2,metrostop3,metrostoptime3);

            //Saving the name
            databaseMetrotime.child(id).setValue(metrotime);

            //setting edittext to blank again
            editTextmetrostop1.setText("");
            editTextmetrostoptime1.setText("");
            editTextmetrostop2.setText("");
            editTextmetrostoptime2.setText("");
            editTextmetrostop3.setText("");
            editTextmetrostoptime3.setText("");

            //displaying a success toast
            Toast.makeText(this, "METRO TIME ADDED", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseMetrotime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                metrostime.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Metrotime metrono = postSnapshot.getValue(Metrotime.class);
                    //adding artist to the list
                    metrostime.add(metrono);
                }

                //creating adapter
                Metrotimelist MetrotimeAdapter = new Metrotimelist(metrotiming.this, metrostime);
                //attaching adapter to the listview
                listViewMetrostime.setAdapter(MetrotimeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}