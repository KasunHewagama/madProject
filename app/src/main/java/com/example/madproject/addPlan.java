package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addPlan extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

//        define variables
        add = (Button) findViewById(R.id.button2);

//        define onClickListner method for each page
        add.setOnClickListener(this);

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
    }
}
