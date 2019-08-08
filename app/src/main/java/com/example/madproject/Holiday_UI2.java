package com.example.madproject;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Holiday_UI2 extends AppCompatActivity {
    TextView mTv1,mTv2;
    Button mBtn1,mBtn2;

    Calendar c1,c2;
    DatePickerDialog dpd1,pdp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui2);

        mTv1=(TextView)findViewById(R.id.textView15);
        mTv2=(TextView)findViewById(R.id.textView16);
        mBtn1=(Button)findViewById(R.id.calpic);
        mBtn2=(Button)findViewById(R.id.enddate);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               c1=Calendar.getInstance();
               int day=c1.get(Calendar.DAY_OF_MONTH);
               int month=c1.get(Calendar.MONTH);
               int year=c1.get(Calendar.YEAR);
               dpd1 = new DatePickerDialog(Holiday_UI2.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTv1.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                   }
               },day,month,year);
               dpd1.show();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         c2=Calendar.getInstance();
                                         int day=c2.get(Calendar.DAY_OF_MONTH);
                                         int month=c2.get(Calendar.MONTH);
                                         int year=c2.get(Calendar.YEAR);
                                         pdp2 = new DatePickerDialog(Holiday_UI2.this, new DatePickerDialog.OnDateSetListener() {
                                             @Override
                                             public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                                                 mTv2.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
                                             }
                                         },day,month,year);
                                         pdp2.show();
                                     }
                                 }


        );


    }
}
