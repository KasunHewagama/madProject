package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newaddcourse extends AppCompatActivity  /*implements View.OnClickListener*/ {

    EditText subjectAC,teacherAC,placeAC,dateAC;
    Button btnclearAC,btnsaveAC;
    DatabaseReference dbref;
    addcoursemodel acm;


    public void  clearData(){
        subjectAC.setText("");
        teacherAC.setText("");
        placeAC.setText("");
        dateAC.setText("");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddcourse);

        subjectAC = findViewById(R.id.subjectAC);
        teacherAC = findViewById(R.id.teacherAC);
        placeAC = findViewById(R.id.placeAC);
        dateAC = findViewById(R.id.dateAC);

        btnclearAC = findViewById(R.id.btnclearAC);
        btnsaveAC = findViewById(R.id.btnsaveAC);

       acm = new addcoursemodel();

        btnclearAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = subjectAC.getText().toString();
                String text2 = teacherAC.getText().toString();
                String text3 = placeAC.getText().toString();
                String text4 = dateAC.getText().toString();

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
                    else if (TextUtils.isEmpty(dateAC.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Date",Toast.LENGTH_SHORT).show();
                    else {
                        acm.setSubject(subjectAC.getText().toString().trim());
                        acm.setTeacher(teacherAC.getText().toString().trim());
                        acm.setPlace(placeAC.getText().toString().trim());
                        acm.setDate(dateAC.getText().toString().trim());

                        dbref.push().setValue(acm);

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
