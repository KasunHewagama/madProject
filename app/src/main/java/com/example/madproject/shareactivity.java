package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class shareactivity extends AppCompatActivity {

    EditText desc,title;
    Button btnadd,btnclear;
    DatabaseReference dbRef;
    ComPost cmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareactivity);

        title = findViewById(R.id.editText9);
        desc = findViewById(R.id.editText16);

        btnadd=findViewById(R.id.button13);
        btnclear=findViewById(R.id.button);
        cmp =new ComPost();
        dbRef= FirebaseDatabase.getInstance().getReference().child("Post");
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(title.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please a title", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(desc.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a description",Toast.LENGTH_SHORT).show();

                    else {

                        cmp.setTitle(title.getText().toString().trim());
                        cmp.setDescription(desc.getText().toString().trim());
                        //dbRef.push().setValue(cmp);
                        dbRef.child(title.getText().toString()).setValue(cmp);

                        Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }

                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Data Inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void clearControls() {

        title.setText("");
        desc.setText("");
    }
}
