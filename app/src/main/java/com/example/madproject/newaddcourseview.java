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

public class newaddcourseview extends AppCompatActivity {
        DatabaseReference dbRefV;
        ListView listView;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter;
        Button btndeleteAC;
        wdelplan delttb;
        //private Button done;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_newaddcourse_view);
            dbRefV = FirebaseDatabase.getInstance().getReference("TimeTable");
            listView = (ListView) findViewById(R.id.lv1);
            btndeleteAC = (Button)findViewById(R.id.btndeleteAC);
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);

            delttb = (wdelplan)getApplicationContext();


            dbRefV.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String value = dataSnapshot.getValue(addcoursemodel.class).toString();
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();
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
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    delttb.setGval_subject(arrayList.get(position));
                    delttb.setGval_teacher(arrayList.get(position));
                }
            });
            btndeleteAC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String ttb = delttb.getGval_subject().substring(0,3);
                    if (ttb==""){
                        Toast.makeText(newaddcourseview.this,"Please Select Item before Delete..!",Toast.LENGTH_SHORT).show();
                    }else {
                        dbRefV.child("TimeTable").child(ttb).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                dbRefV.child(ttb).removeValue();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        Toast.makeText(newaddcourseview.this,"Course is Deleted..!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),newaddcourseview.class);
                        startActivity(intent);
                    }
                }
            });
        }

    }
