package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.madproject.R.id.grid1;

public class MainActivity extends AppCompatActivity  {


    private Button work,holiday,timetable,community;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //defining layouts
       work =(Button) findViewById(R.id.button4);
       holiday=(Button) findViewById(R.id.button5);
       timetable =(Button) findViewById(R.id.button6);
       community=(Button) findViewById(R.id.button7);

    work.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this,workoutHomepage.class));
        }
    });

        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Holiday_UI1.class));
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Timetable.class));
            }
        });




//    }


}}
