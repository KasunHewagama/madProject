package com.example.madproject;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Holiday_UI2 extends AppCompatActivity implements View.OnClickListener {
    EditText pname,pdiscription;
    TextView mTv1, mTv2;
    Button mBtn1, mBtn2, maddBtn,mclearBtn;
    DatabaseReference HDBRef;
    HolidayData holidayData;

    Calendar c1, c2;
    DatePickerDialog dpd1, pdp2;


    //clear user inputs
    private void HclearCotrols() {
        pname.setText("");
        mTv1.setText("");
        mTv2.setText("");

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui2);


        pname = findViewById(R.id.Ipname);
        mTv1 = (TextView) findViewById(R.id.Isdate);
        mTv2 = (TextView) findViewById(R.id.Iedate);
        //pdiscription= (EditText) findViewById(R.id.Idiscription2);


        mBtn1 = (Button) findViewById(R.id.calpic);
        mBtn2 = (Button) findViewById(R.id.enddate);
        maddBtn = findViewById(R.id.btnadd);
        mclearBtn=findViewById(R.id.btnclear);
        holidayData = new HolidayData();
        //maddBtn = (Button) findViewById(R.id.btnadd);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                c1 = Calendar.getInstance();
                int day = c1.get(Calendar.DAY_OF_MONTH);
                int month = c1.get(Calendar.MONTH);
                int year = c1.get(Calendar.YEAR);
                dpd1 = new DatePickerDialog(Holiday_UI2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                       mTv1.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                dpd1.show();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         c2 = Calendar.getInstance();
                                         int day = c2.get(Calendar.DAY_OF_MONTH);
                                         int month = c2.get(Calendar.MONTH);
                                        int year = c2.get(Calendar.YEAR);
                                         pdp2 = new DatePickerDialog(Holiday_UI2.this, new DatePickerDialog.OnDateSetListener() {
                                             @Override
                                             public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                                                 mTv2.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                                             }
                                         }, day, month, year);
                                         pdp2.show();
                                     }
                                 }


        );
        mclearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Text1=pname.getText().toString();
                String Text2=mTv1.getText().toString();
                String Text3=mTv2.getText().toString();
              //  String Text4=pdiscription.getText().toString();

                if (Text1.isEmpty())
                    Toast.makeText(getApplicationContext(),"Planname is Already Empty",Toast.LENGTH_SHORT).show();
                else{
                    pname.setText("");
                }
                if(Text2.isEmpty())
                    Toast.makeText(getApplicationContext(),"Starting date is Already Empty",Toast.LENGTH_SHORT).show();
                else{
                    mTv1.setText("");
                }
                if (Text3.isEmpty())
                    Toast.makeText(getApplicationContext(),"Ending date is Already Empty",Toast.LENGTH_SHORT).show();
                else{
                    mTv2.setText("");
                }
                //if (Text4.isEmpty())
                  //  Toast.makeText(getApplicationContext(),"Discription is already empty",Toast.LENGTH_SHORT).show();
                //else{
                  //  pdiscription.setText("");
                //}
            }
        });

    }

    @Override
    public void onClick(View view) {
        HDBRef=FirebaseDatabase.getInstance().getReference().child("HolidayData");
        try{
            if (TextUtils.isEmpty(pname.getText().toString()))
                Toast.makeText(getApplicationContext(),"please Enter a Name",Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(mTv1.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please select a starting date",Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(mTv2.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please select ending date",Toast.LENGTH_SHORT).show();
            //else if (TextUtils.isEmpty(pdiscription.getText().toString()))
                //Toast.makeText(getApplicationContext(),"Please Write a discription about your plan",Toast.LENGTH_SHORT).show();
            else {
                holidayData.setPname(pname.getText().toString().trim());
                holidayData.setSdate(mTv1.getText().toString().trim());
                holidayData.setEdate(mTv2.getText().toString().trim());
                //holidayData.setHdiscription(pdiscription.getText().toString().trim());

                HDBRef.push().setValue(holidayData);

                Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                HclearCotrols();
            }
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
        }
    }
}

