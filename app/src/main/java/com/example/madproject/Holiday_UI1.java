package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Holiday_UI1 extends AppCompatActivity implements View.OnClickListener {
    private CardView Hcd1,Hcd2,Hcd3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui1);
        //assign variables
         Hcd1 = (CardView)findViewById(R.id.PLAN);
         Hcd2=(CardView)findViewById(R.id.WORK);
         Hcd3=(CardView)findViewById(R.id.MEMORIES);
         //pass variables to setOnClickListner method to super class
         Hcd1.setOnClickListener(this);
         Hcd2.setOnClickListener(this);
         Hcd3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent I;

        switch (view.getId()){
            case R.id.PLAN: I=new Intent(this,Holiday_UI2.class);
                                startActivity(I);
                                break;
            case R.id.WORK: I=new Intent(this,Holiday_UI3.class);
                                startActivity(I);
                                break;
            case R.id.MEMORIES: I=new Intent(this,Holiday_UI5.class);
                                startActivity(I);
                                break;
             default:           break;

        }
    }
}
