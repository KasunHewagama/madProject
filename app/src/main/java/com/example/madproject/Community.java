package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Community extends AppCompatActivity implements View.OnClickListener{

    private CardView find,share,feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        find = (CardView)findViewById(R.id.cardId5);
        share = (CardView)findViewById(R.id.cardId6);
        feed = (CardView)findViewById(R.id.cardId7);


        find.setOnClickListener(this);
        share.setOnClickListener(this);
        feed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId())
        {
            case R.id.cardId5:i=new Intent(this,findfriends.class);startActivity(i);break;
            case R.id.cardId6:i=new Intent(this,shareactivity.class);startActivity(i);break;
            case R.id.cardId7:i=new Intent(this,feedcom.class);startActivity(i);break;

            default:break;
        }



    }
}
