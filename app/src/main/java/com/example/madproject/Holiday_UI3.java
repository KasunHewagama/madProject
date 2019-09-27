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

public class Holiday_UI3 extends AppCompatActivity {

    DatabaseReference href;
    ListView hlistView;
    ArrayList<String> harrayList = new ArrayList<>();
    ArrayAdapter<String> harrayAdapter;
    Button del;
    wdelplan module;
    //private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui3);

        href = FirebaseDatabase.getInstance().getReference("HolidayData");
        hlistView = (ListView) findViewById(R.id.holidaylistview);
        del=(Button)findViewById(R.id.btndel);
        module=(wdelplan) getApplicationContext();
        harrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,harrayList);
        hlistView.setAdapter(harrayAdapter);
        href.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(HolidayData.class).toString();
                harrayList.add(value);
                harrayAdapter.notifyDataSetChanged();
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
        hlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                module.setValue_name(harrayList.get(i));
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str=module.getValue_name().substring(0,5);
                if(str==""){
                    Toast.makeText(Holiday_UI3.this,"Please select item before delete",Toast.LENGTH_LONG).show();
                }else{
                    href.child("HolidayData").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            href.child(str).removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(Holiday_UI3.this,"Delete Succesfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Holiday_UI3.class);
                    startActivity(intent);
                }
            }
        });
    }
}
