package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class addPlan extends AppCompatActivity implements View.OnClickListener {

//    private Button add;
    EditText txtworkout;
    Button btnadd,btnclr;
    DatabaseReference dbRefw;
    addPlanA aPA;

    private void clearControls(){
        txtworkout.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        txtworkout = findViewById(R.id.workoutnameA);


        btnadd = findViewById(R.id.btnaddA);
        btnclr = findViewById(R.id.btnclrA);

        aPA = new addPlanA();

//        define variables
//        add = (Button) findViewById(R.id.btnaddA);

//        define onClickListner method for each page
//        add.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
//        Intent intent06;
//
//        switch (view.getId()){
//            case R.id.cardId5: intent06 = new Intent(this,addView.class);
//                startActivity(intent06);
//                break;
//            default:break;
//        }

        dbRefw = FirebaseDatabase.getInstance().getReference().child("Workout");
        try {
            if (TextUtils.isEmpty(txtworkout.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
            else {
                aPA.setWorkoutName(txtworkout.getText().toString().trim());
                dbRefw.push().setValue(aPA);

                Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                clearControls();
            }

        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Invalid Data Inserted",Toast.LENGTH_SHORT).show();
        }

    }
}
