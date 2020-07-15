package com.example.appfortransport;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class trainticketbooking extends AppCompatActivity {

    EditText editTextNametrain;
    EditText editTextphonetrain;
    Spinner editTexttrainnumber;
    Spinner spinnertrain;
    Spinner spinnertrain1;
    Button buttonAddtrain;
    TextView trainticketcount;
    private int count=30;

    private static final String TAG = "trainticketbooking";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    List<Train> trains;
    DatabaseReference databaseTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainticketbooking);



        mDisplayDate = (TextView) findViewById(R.id.tvtrainDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        trainticketbooking.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };


        databaseTrain = FirebaseDatabase.getInstance().getReference("trains");

        //getting views
        editTextNametrain = (EditText) findViewById(R.id.editTextNametrain);
        editTextphonetrain = (EditText) findViewById(R.id.editTextphonetrain);
        editTexttrainnumber = (Spinner) findViewById(R.id.editTexttrainnumber);
        spinnertrain = (Spinner) findViewById(R.id.spinnertrain);
        spinnertrain1 = (Spinner) findViewById(R.id.spinnertrain1);


        buttonAddtrain = (Button) findViewById(R.id.buttonAddtrain);

        //list to store name of the booker
        trains = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddtrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation
                if(count>0) {
                    addtrain();
                    count--;
                    trainticketcount.setText("No of tickets remaining: " + count);
                }
                else{
                    trainticketcount.setText("Book any other train");
                }
            }
        });
    }

    private void addtrain() {
        //getting the values to save
        String name = editTextNametrain.getText().toString().trim();
        String phone = editTextphonetrain.getText().toString().trim();
        String trainno = editTexttrainnumber.getSelectedItem().toString();
        String from = spinnertrain.getSelectedItem().toString();
        String to = spinnertrain1.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseTrain.push().getKey();

            //creating an train Object
            Train train = new Train(id, name, phone,trainno, from,to);

            //Saving the name
            databaseTrain.child(id).setValue(train);

            //setting edittext to blank again
            editTextNametrain.setText("");

            //displaying a success toast
            Toast.makeText(this, "Train ticket booked", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}