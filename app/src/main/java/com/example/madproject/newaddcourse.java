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

public class newaddcourse extends AppCompatActivity  /*implements View.OnClickListener*/ {

    EditText subjectAC,teacherAC,placeAC,timeAC,dateAC;
    Button btnclearAC,btnsaveAC;
    DatabaseReference dbref;
    addcoursemodel acm;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    Calendar cal1;
    DatePickerDialog DPD1;


    public void  clearData(){
        subjectAC.setText("");
        teacherAC.setText("");
        placeAC.setText("");
        timeAC.setText("");
        dateAC.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddcourse);

        subjectAC = findViewById(R.id.subjectAC);
        teacherAC = findViewById(R.id.teacherAC);
        placeAC = findViewById(R.id.placeAC);
        timeAC = findViewById(R.id.timeAC);
        dateAC = findViewById(R.id.dateAC);

        btnclearAC = findViewById(R.id.btnclearAC);
        btnsaveAC = findViewById(R.id.btnsaveAC);

         acm = new addcoursemodel();

        timeAC.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(newaddcourse.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay >= 12){
                            hourOfDay =  hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
                        timeAC.setText(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                    }
                },currentHour,currentMinute,true);
                timePickerDialog.show();
            }

        });
        dateAC.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                cal1 = Calendar.getInstance();
                int day = cal1.get(Calendar.DAY_OF_MONTH);
                int month = cal1.get(Calendar.MONTH);
                int year = cal1.get(Calendar.YEAR);
                DPD1 = new DatePickerDialog(newaddcourse.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        dateAC.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                DPD1.show();
            }
        });
        btnclearAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = subjectAC.getText().toString();
                String text2 = teacherAC.getText().toString();
                String text3 = placeAC.getText().toString();
                String text4 = timeAC.getText().toString();
                String text5 = dateAC.getText().toString();

                if (text1.isEmpty())
                    Toast.makeText(getApplicationContext(),"subject cleared",Toast.LENGTH_SHORT).show();
                else {
                    subjectAC.setText("");
                }
                if (text2.isEmpty())
                    Toast.makeText(getApplicationContext(),"Teacher name cleared",Toast.LENGTH_SHORT).show();
                else {

                    teacherAC.setText("");
                }
                if (text3.isEmpty())
                    Toast.makeText(getApplicationContext(),"place cleared",Toast.LENGTH_SHORT).show();
                else {
                    placeAC.setText("");
                }
                if (text4.isEmpty())
                    Toast.makeText(getApplicationContext(),"time cleared",Toast.LENGTH_SHORT).show();
                else {
                    timeAC.setText("");
                }
                if (text5.isEmpty())
                    Toast.makeText(getApplicationContext(),"date cleared",Toast.LENGTH_SHORT).show();
                else {
                    dateAC.setText("");
                }

            }
        });
        btnsaveAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("TimeTable");
                try {
                    if (TextUtils.isEmpty(subjectAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Subject Name",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(teacherAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Teacher Name",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(placeAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Place",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(timeAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please Select a Place",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(dateAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Date",Toast.LENGTH_SHORT).show();
                    else {
                        acm.setSubject(subjectAC.getText().toString().trim());
                        acm.setTeacher(teacherAC.getText().toString().trim());
                        acm.setPlace(placeAC.getText().toString().trim());
                        acm.setTime(timeAC.getText().toString().trim());
                        acm.setDate(dateAC.getText().toString().trim());

                        //dbref.push().setValue(acm);
                        dbref.child(subjectAC.getText().toString()).setValue(acm);
                        Toast.makeText(getApplicationContext(),"Data insert Successfully",Toast.LENGTH_LONG).show();

                        clearData();
                        /* dbref.child("subject").setValue(acm);
                        dbref.child("teacher").setValue(acm);
                        dbref.child("place").setValue(acm);
                        dbref.child("date").setValue(acm);*/

                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Data Inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
