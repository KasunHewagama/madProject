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

public class addView extends AppCompatActivity {

    DatabaseReference dbRefV;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button btnDelete;
    Button btnUpdate;
    wdelplan wDelPlan;

    //private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        dbRefV = FirebaseDatabase.getInstance().getReference("Workout");
        listView = (ListView) findViewById(R.id.listviewtxt);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        wDelPlan=((wdelplan)getApplicationContext());
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        dbRefV .addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(addPlanA.class).toString();
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                wDelPlan.setGvalue_workoutName(arrayList.get(i));
                wDelPlan.setGvalue_startingTime(arrayList.get(i));
            }
        });

        btnUpdate.setOnClickListener(view -> {
           // if ()
        });



        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str = wDelPlan.getGvalue_workoutName().substring(0,8);
                if (str==""){
                    Toast.makeText(addView.this,"Please Select Item before Delete..!",Toast.LENGTH_SHORT).show();
                }else {
                    dbRefV.child("Workout").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            dbRefV.child(str).removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(addView.this,"Workout is Deleted..!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),addView.class);
                    startActivity(intent);
                }
            }
        });


    }
}
