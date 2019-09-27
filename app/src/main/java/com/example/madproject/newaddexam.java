package com.example.madproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newaddexam extends AppCompatActivity {

    EditText examAE,subjectAE,placeAE,timeAE,dateAE;
    Button btnclearAE,btnsaveAE;
    DatabaseReference dbref;
    newaddexammodel naem;

    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    Calendar cal1;
    DatePickerDialog DPD1;

    public void  clearData(){
        examAE.setText("");
        subjectAE.setText("");
        placeAE.setText("");
        timeAE.setText("");
        dateAE.setText("");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddexam);

        examAE = findViewById(R.id.examAE);
        subjectAE = findViewById(R.id.subjectAE);
        placeAE = findViewById(R.id.placeAE);
        timeAE = findViewById(R.id.timeAE);
        dateAE = findViewById(R.id.dateAE);

        btnclearAE = findViewById(R.id.btnclearAE);
        btnsaveAE = findViewById(R.id.btnsaveAE);

        naem = new newaddexammodel();

        timeAE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(newaddexam.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay >= 12){
                            hourOfDay =  hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
                        timeAE.setText(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                    }
                },currentHour,currentMinute,true);
                timePickerDialog.show();
            }

        });
        dateAE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                cal1 = Calendar.getInstance();
                int day = cal1.get(Calendar.DAY_OF_MONTH);
                int month = cal1.get(Calendar.MONTH);
                int year = cal1.get(Calendar.YEAR);
                DPD1 = new DatePickerDialog(newaddexam.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        dateAE.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                DPD1.show();
            }
        });
        btnclearAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = examAE.getText().toString();
                String text2 = subjectAE.getText().toString();
                String text3 = placeAE.getText().toString();
                String text4 = timeAE.getText().toString();
                String text5 = dateAE.getText().toString();

                if (text1.isEmpty())
                    Toast.makeText(getApplicationContext(),"subject cleared",Toast.LENGTH_SHORT).show();
                else {
                    examAE.setText("");
                }
                if (text2.isEmpty())
                    Toast.makeText(getApplicationContext(),"Teacher name cleared",Toast.LENGTH_SHORT).show();
                else {

                    subjectAE.setText("");
                }
                if (text3.isEmpty())
                    Toast.makeText(getApplicationContext(),"place cleared",Toast.LENGTH_SHORT).show();
                else {
                    placeAE.setText("");
                }
                if (text4.isEmpty())
                    Toast.makeText(getApplicationContext(),"Time cleared",Toast.LENGTH_SHORT).show();
                else {

                    timeAE.setText("");
                }
                if (text5.isEmpty())
                    Toast.makeText(getApplicationContext(),"date cleared",Toast.LENGTH_SHORT).show();
                else {

                    dateAE.setText("");
                }

            }
        });
        btnsaveAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("Exam");
                try {
                    if (TextUtils.isEmpty(examAE.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Exam Name",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(subjectAE.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Subject Name",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(placeAE.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Place",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(timeAE.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please Set a Time",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(dateAE.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please Set a Date",Toast.LENGTH_SHORT).show();
                    else {
                        naem.setExam(examAE.getText().toString().trim());
                        naem.setSubject(subjectAE.getText().toString().trim());
                        naem.setPlace(placeAE.getText().toString().trim());
                        naem.setDate(timeAE.getText().toString().trim());
                        naem.setDate(dateAE.getText().toString().trim());

                        dbref.push().setValue(naem);
                       /* dbref.child("subject").setValue(acm);
                        dbref.child("teacher").setValue(acm);
                        dbref.child("place").setValue(acm);
                        dbref.child("date").setValue(acm);*/



                        Toast.makeText(getApplicationContext(),"Data added Successfully",Toast.LENGTH_SHORT).show();
                        clearData();
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Data Inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
