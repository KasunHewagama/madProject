package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    private CardView work,holiday,timetable,community;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        work=(CardView)findViewById(R.id.cardId1);
        holiday=(CardView)findViewById(R.id.cardId2);
        timetable=(CardView)findViewById(R.id.cardId3);
        community=(CardView)findViewById(R.id.cardId4);

        work.setOnClickListener(this);
        holiday.setOnClickListener(this);
        timetable.setOnClickListener(this);
        community.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {
            case R.id.cardId1 : i=new Intent(this,workoutHomepage.class);startActivity(i);break;

            case R.id.cardId2 : i=new Intent(this,Holiday_UI1.class);startActivity(i);break;

            case R.id.cardId3 : i=new Intent(this,Timetable.class);startActivity(i);break;

            case R.id.cardId4 : i=new Intent(this,workoutHomepage.class);startActivity(i);break;

            default:break;
        }

    }
}
