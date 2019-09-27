package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Holiday_UI3 extends AppCompatActivity /*implements View.OnClickListener*/ {
    // private CardView PVcd1, PVcd2, PVcd3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference HviewRef;
        ListView listView;
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday__ui3);
        HviewRef = FirebaseDatabase.getInstance().getReference("HolidayData");
       // listView = (ListView) findViewById(R.id.listviewtxt);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
     //   listView.setAdapter(arrayAdapter);
        HviewRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(HolidayData.class).toString();
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
        // PVcd2 = (CardView) findViewById(R.id.textView15);
        /*PVcd1 = (CardView) findViewById(R.id.VM1);
        PVcd2 = (CardView) findViewById(R.id.VP2);
        PVcd3 = (CardView) findViewById(R.id.VP3);

        PVcd1.setOnClickListener(this);
        PVcd2.setOnClickListener(this);
        PVcd3.setOnClickListener(this);
    }

    @Override()
    public void onClick(View view) {
        Intent I;

        //switch (view.getId()) {
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
          //  case R.id.VM1:
            //    I = new Intent(this, Holiday_UI4.class);
              //  startActivity(I);
                //break;
            //case R.id.VP2:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //case R.id.VP3:
              //  I = new Intent(this, Holiday_UI4.class);
                //startActivity(I);
                //break;
            //default: break;
        //}
   // }
            case R.id.VM1:
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
         */
    }
}