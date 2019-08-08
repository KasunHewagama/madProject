package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Holiday_UI3 extends AppCompatActivity implements View.OnClickListener {
    private CardView PVcd1, PVcd2, PVcd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui3);

        PVcd1 = (CardView) findViewById(R.id.VP1);
        PVcd2 = (CardView) findViewById(R.id.VP2);
        PVcd3 = (CardView) findViewById(R.id.VP3);

        PVcd1.setOnClickListener(this);
        PVcd2.setOnClickListener(this);
        PVcd3.setOnClickListener(this);
    }

    @Override()
    public void onClick(View view) {
        Intent I;

        switch (view.getId()) {
            case R.id.VP1:
                I = new Intent(this, Holiday_UI4.class);
                startActivity(I);
                break;
            case R.id.VP2:
                I = new Intent(this, Holiday_UI4.class);
                startActivity(I);
                break;
            case R.id.VP3:
                I = new Intent(this, Holiday_UI4.class);
                startActivity(I);
                break;
            default: break;
        }
    }
}