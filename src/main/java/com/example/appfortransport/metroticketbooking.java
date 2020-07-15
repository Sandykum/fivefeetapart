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

public class metroticketbooking extends AppCompatActivity {

    EditText editTextNamemetro;
    EditText editTextphonemetro;
    Spinner editTextmetrono;
    Spinner spinnermetro;
    Spinner spinnermetro1;
    Button buttonAddmetro;
    public int count=30;
    TextView ticketmetrocount;

    private static final String TAG = "metroticketbooking";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    List<Metro> metros;
    DatabaseReference databaseMetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metroticketbooking);


        mDisplayDate = (TextView) findViewById(R.id.tvmetroDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        metroticketbooking.this,
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


        databaseMetro = FirebaseDatabase.getInstance().getReference("metros");

        //getting views
        editTextNamemetro = (EditText) findViewById(R.id.editTextNamemetro);
        editTextphonemetro = (EditText) findViewById(R.id.editTextphonemetro);
        editTextmetrono = (Spinner) findViewById(R.id.editTextmetronumber);
        spinnermetro = (Spinner) findViewById(R.id.spinnermetro);
        spinnermetro1 = (Spinner) findViewById(R.id.spinnermetro1);
        ticketmetrocount=(TextView) findViewById(R.id.metroseatbooked);



        buttonAddmetro = (Button) findViewById(R.id.buttonAddmetro);

        //list to store name of the booker
        metros = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddmetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation
                if(count>0) {
                    addMetro();
                    count--;
                    ticketmetrocount.setText("No of tickets remaining: " + count);
                }
                else
                {
                    ticketmetrocount.setText("Book anyother metro" );
                }
            }
        });
    }

    private void addMetro() {
        //getting the values to save
        String name = editTextNamemetro.getText().toString().trim();
        String phone = editTextphonemetro.getText().toString().trim();
        String metrono = editTextmetrono.getSelectedItem().toString();
        String from = spinnermetro.getSelectedItem().toString();
        String to = spinnermetro1.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseMetro.push().getKey();

            //creating an name Object
            Metro metro = new Metro(id, name, phone, metrono, from,to);

            //Saving the name
            databaseMetro.child(id).setValue(metro);

            //setting edittext to blank again
            editTextNamemetro.setText("");

            //displaying a success toast
            Toast.makeText(this, "Train Ticket booked", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}