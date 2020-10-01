package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addcoursehomepage extends AppCompatActivity implements View.OnClickListener {
    private CardView add, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse_homepage);


        add = (CardView) findViewById(R.id.card001AC);
        view = (CardView) findViewById(R.id.card002AC);
        add.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intento;

        switch (view.getId()) {
            case R.id.card001AC:
                intento = new Intent(this, newaddcourse.class);
                startActivity(intento);
                break;
            case R.id.card002AC:
                intento = new Intent(this, newaddcourseview.class);
                startActivity(intento);
                break;
            default:break;
        }
    }
}
