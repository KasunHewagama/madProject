package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addView extends AppCompatActivity implements View.OnClickListener {

    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

//        define variables
        done = (Button) findViewById(R.id.button7);

//        define OnClickListner method to each page

        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent07;

        switch (view.getId()){
            case R.id.cardId5: intent07 = new Intent(this,donnedWorkout.class);
                startActivity(intent07);
                break;
            default:break;
        }
    }

}
