package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class timetable extends AppCompatActivity implements View.OnClickListener {

    private CardView course,exam,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        course = (CardView)findViewById(R.id.cardId001);
        exam = (CardView)findViewById(R.id.cardId002);
        result = (CardView)findViewById(R.id.cardId003);

        course.setOnClickListener(this);
        exam.setOnClickListener(this);
        result.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {
            case R.id.cardId001 : i = new Intent(this,newaddcourse.class);startActivity(i);
            break;

            case R.id.cardId002 : i = new Intent(this,newaddexam.class);startActivity(i);
            break;

            case R.id.cardId003 : i =new Intent(this,newaddresults.class);startActivity(i);
            break;

            default:break;
        }

    }
}
