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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class busticketbooking extends AppCompatActivity {

    EditText editTextNamebus;
    EditText editTextphonebus;
    Spinner editTextbusnumber;
    Spinner spinnerbus;
    Spinner spinnerbus1;
    Button buttonAddbus;
    public int count=30;
    TextView ticketcount;

    private static final String TAG = "busticketbooking";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    List<Bus> buses;
    DatabaseReference databaseBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busticketbooking);

        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        busticketbooking.this,
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




        databaseBus = FirebaseDatabase.getInstance().getReference("buses");

        //getting views
        editTextNamebus = (EditText) findViewById(R.id.editTextNamebus);
        editTextphonebus = (EditText) findViewById(R.id.editTextphonebus);
        editTextbusnumber = (Spinner) findViewById(R.id.editTextbusnumber);
        spinnerbus = (Spinner) findViewById(R.id.spinnerbus);
        spinnerbus1 = (Spinner) findViewById(R.id.spinnerbus1);
        buttonAddbus = (Button) findViewById(R.id.buttonAddbus);
        ticketcount=(TextView) findViewById(R.id.busseatbooked);

        //list to store name of the booker
        buses = new ArrayList<>();

        //checking whether they can book the ticket


            //adding an onclicklistener to button
            buttonAddbus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //the method is defined below
                    //this method is actually performing the write operation
                    if(count>0) {
                        addBus();
                        count--;
                        ticketcount.setText("No of tickets remaining: " + count);
                    }
                    else{
                        ticketcount.setText("Book any other bus");
                    }
                }
            });

    }

    private void addBus() {
        //getting the values to save
        String name = editTextNamebus.getText().toString().trim();
        String phone = editTextphonebus.getText().toString().trim();
        String busno = editTextbusnumber.getSelectedItem().toString();
        String from = spinnerbus.getSelectedItem().toString();
        String to = spinnerbus1.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseBus.push().getKey();

            //creating an name Object
            Bus bus = new Bus(id, name,phone,busno,from,to);

            //Saving the name
            databaseBus.child(id).setValue(bus);

            //setting edittext to blank again
            editTextNamebus.setText("");

            //displaying a success toast
            Toast.makeText(this, "BUS TICKET BOOKED", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}