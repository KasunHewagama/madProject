package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
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

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;


public class addPlan extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

//    private Button add;
    EditText txtworkout,txtstrtm,txtendtm,txtdist;
    Button btnadd,btnclr,btnstrtm,btnendtm,add;
    int hour,minute;
    int hourFinal, minuteFinal;

    DatabaseReference dbRefw;
    addPlanA aPA;

    private void clearControls(){
        txtworkout.setText("");
        txtstrtm.setText("");
        txtendtm.setText("");
        txtdist.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        txtworkout = findViewById(R.id.workoutnameA);
        txtstrtm =  findViewById(R.id.txtstarttimeA);
        txtendtm = findViewById(R.id.txtendtimeA);
        txtdist = findViewById(R.id.txtdistanceA);


        btnadd = findViewById(R.id.btnaddA);
        btnclr = findViewById(R.id.btnclrA);
        btnstrtm = findViewById(R.id.starttimeA);
        btnendtm = findViewById(R.id.endtimeA);


        aPA = new addPlanA();

       // define variables
        add = (Button) findViewById(R.id.btnaddA);

        //define onClickListner method for each page
        add.setOnClickListener(this);

        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = txtworkout.getText().toString();
                String text2 = txtstrtm.getText().toString();
                String text3 = txtendtm.getText().toString();
                String text4 = txtdist.getText().toString();
                if (text1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Workout Name is Empty...!", Toast.LENGTH_SHORT).show();
                    if (text2.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Starting Time is Empty...!", Toast.LENGTH_SHORT).show();
                        if (text3.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Ending Time is Empty...!", Toast.LENGTH_SHORT).show();
                            if (text4.isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Distance is Empty...!", Toast.LENGTH_SHORT).show();
                            } else {
                                txtdist.setText("");
                            }
                        } else {
                            txtendtm.setText("");
                        }
                    } else {
                        txtstrtm.setText("");
                    }
                } else {
                    txtworkout.setText("");
                }
                if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Workout Name is Empty...!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Starting Time is Empty...!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Ending Time is Empty...!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Distance is Empty...!", Toast.LENGTH_SHORT).show();

                } else {
                    txtdist.setText("");
                    txtendtm.setText("");
                    txtstrtm.setText("");
                    txtworkout.setText("");

                }
            }
        });



    }


    @Override
    public void onClick(View view) {
        Intent intent06;

        switch (view.getId()){
            case R.id.cardId5: intent06 = new Intent(this,addView.class);
                startActivity(intent06);
                break;
            default:break;
        }

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

//        TimePickerDialog timePickerDialog = new TimePickerDialog(addPlan.this, addPlan.this,
//                hour, minute, DateFormat.getTimeInstance(this)) ;
//        timePickerDialog.show();



        dbRefw = FirebaseDatabase.getInstance().getReference().child("Workout");
        try {
            if (TextUtils.isEmpty(txtworkout.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtstrtm.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter a Starting Time",Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtendtm.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter a Ending Time",Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtdist.getText().toString()))
                Toast.makeText(getApplicationContext(),"Please enter a Distance",Toast.LENGTH_SHORT).show();
            else {
                aPA.setWorkoutName(txtworkout.getText().toString().trim());
                aPA.setStartingTime(txtstrtm.getText().toString().trim());
                aPA.setEndingTime(txtendtm.getText().toString().trim());
                aPA.setDistance(Integer.parseInt(txtdist.getText().toString().trim()));
                dbRefw.push().setValue(aPA);

                Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                clearControls();
            }

        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Invalid Data Inserted",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;

        txtstrtm.setText(hourFinal+":"+minuteFinal);

    }


}
