package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginact extends AppCompatActivity implements View.OnClickListener {

    private TextView signup;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginact);

        signup = (TextView)findViewById(R.id.textView35);
        bt = (Button)findViewById(R.id.button17) ;
        signup.setOnClickListener(this);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.textView35:i=new Intent(this,signup.class);startActivity(i);break;
            case R.id.button17:i=new Intent(this,profile.class);startActivity(i);break;
            default:break;
        }
    }
}
