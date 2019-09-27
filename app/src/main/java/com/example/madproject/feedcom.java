package com.example.madproject;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class feedcom extends AppCompatActivity {
    DatabaseReference href;
    ListView clistView;
    ArrayList<String> carrayList = new ArrayList<>();
    ArrayAdapter<String> carrayAdapter;
    Button del;
    wdelplan DelCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedcom);
        href = FirebaseDatabase.getInstance().getReference("Post");
        clistView = (ListView) findViewById(R.id.mdata);
        del=(Button)findViewById(R.id.button5);
        //module=(Module)getApplicationContext();
        carrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,carrayList);
        clistView.setAdapter(carrayAdapter);
        DelCom = (wdelplan)getApplicationContext();
        href.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(ComPost.class).toString();
                carrayList.add(value);
                carrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        clistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DelCom.setGvalue_title(carrayList.get(position));
                DelCom.setGetGvalue_Description(carrayList.get(position));
            }
        });
        //new delete  new
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String com = DelCom.getGvalue_title().substring(0,8);
                if (com ==""){
                    Toast.makeText(feedcom.this,"Please Select Item before Delete",Toast.LENGTH_SHORT).show();
                }else {
                    href.child("Post").child(com).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            href.child(com).removeValue();
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(feedcom.this,"Post is Deleted",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),feedcom.class);
                    startActivity(intent);
                }
            }
        });







    }
}
