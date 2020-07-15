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

public class traintiming extends AppCompatActivity {

    EditText editTexttrainstop1;
    EditText editTexttrainstoptime1;
    EditText editTexttrainstop2;
    EditText editTexttrainstoptime2;
    EditText editTexttrainstop3;
    EditText editTexttrainstoptime3;
    Button   buttonAddtraintime;
    public ListView listViewTrainstime;
    List<Traintime> trainstime;
    DatabaseReference databaseTraintime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traintiming);

        databaseTraintime = FirebaseDatabase.getInstance().getReference("trainstime");
        listViewTrainstime = (ListView) findViewById(R.id.listViewTrainstime);

      /*  //getting views
        editTexttrainstop1 = (EditText) findViewById(R.id.editTexttrainstop1);
        editTexttrainstoptime1 = (EditText) findViewById(R.id.editTexttrainstoptime1);
        editTexttrainstop2 = (EditText) findViewById(R.id.editTexttrainstop2);
        editTexttrainstoptime2 = (EditText) findViewById(R.id.editTexttrainstoptime2);
        editTexttrainstop3 = (EditText) findViewById(R.id.editTexttrainstop3);
        editTexttrainstoptime3 = (EditText) findViewById(R.id.editTexttrainstoptime3);
        buttonAddtraintime = (Button) findViewById(R.id.buttonAddtraintime);
*/

        //list to store name of the booker
        trainstime = new ArrayList<>();

        //checking whether they can book the ticket

/*
        //adding an onclicklistener to button
        buttonAddtraintime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation

                addTraintime();

            }
        });

    }


    private void addTraintime() {
        //getting the values to save
        String trainstop1 = editTexttrainstop1.getText().toString().trim();
        String trainstoptime1 = editTexttrainstoptime1.getText().toString().trim();
        String trainstop2 = editTexttrainstop2.getText().toString().trim();
        String trainstoptime2 = editTexttrainstoptime2.getText().toString().trim();
        String trainstop3 = editTexttrainstop3.getText().toString().trim();
        String trainstoptime3 = editTexttrainstoptime3.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(trainstop1)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseTraintime.push().getKey();

            //creating an name Object
            Traintime traintime = new Traintime(id, trainstop1,trainstoptime1,trainstop2,trainstoptime2,trainstop3,trainstoptime3);

            //Saving the name
            databaseTraintime.child(id).setValue(traintime);

            //setting edittext to blank again
            editTexttrainstop1.setText("");
            editTexttrainstoptime1.setText("");
            editTexttrainstop2.setText("");
            editTexttrainstoptime2.setText("");
            editTexttrainstop3.setText("");
            editTexttrainstoptime3.setText("");

            //displaying a success toast
            Toast.makeText(this, "TRAIN TIME ADDED", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseTraintime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous  list
                trainstime.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Traintime trainno = postSnapshot.getValue(Traintime.class);
                    //adding artist to the list
                    trainstime.add(trainno);
                }

                //creating adapter
                Traintimelist TraintimeAdapter = new Traintimelist(traintiming.this, trainstime);
                //attaching adapter to the listview
                listViewTrainstime.setAdapter(TraintimeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}