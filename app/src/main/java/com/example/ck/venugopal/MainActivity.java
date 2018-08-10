package com.example.ck.venugopal;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4;
    int switchmain;
    boolean temp1,temp2,temp3,temp4;
    Switch switch1;
    ImageView img1,img2,img3,img4;
    Button watch1,watch2,watch3,watch4;
    TextView textView1,textView2,textView3,textView4;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference  MCB   = database.getReference("switchmain");
    DatabaseReference relay1 = database.getReference("relay1");
    DatabaseReference relay2 = database.getReference("relay2");
    DatabaseReference relay3 = database.getReference("relay3");
    DatabaseReference relay4 = database.getReference("relay4");
    DatabaseReference text1 = database.getReference("text1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        switch1 = findViewById(R.id.switch1);
       /* editText1= findViewById(R.id.editText1);
        editText2= findViewById(R.id.editText2);
        editText3= findViewById(R.id.editText3);
        editText4= findViewById(R.id.editText4);
       */
        watch1 = findViewById(R.id.watch1);
        watch2 = findViewById(R.id.watch2);
        watch3 = findViewById(R.id.watch3);
        watch4 = findViewById(R.id.watch4);



        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchmain==0) {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    MCB.setValue(switchmain);
                    switchmain = 1;
                    relay1.setValue(true);
                  /*  try {
                        TimeUnit.MINUTES.sleep(1);
                    }
                    catch (Exception e)
                    {
                        System.out.println("NOt working code");
                    }*/
                    relay2.setValue(true);
                    relay3.setValue(true);
                    relay4.setValue(true);

                }

                else
                {
                    img1.setImageResource(R.drawable.ic_slide_switch_off);
                    img2.setImageResource(R.drawable.ic_slide_switch_off);
                    img3.setImageResource(R.drawable.ic_slide_switch_off);
                    img4.setImageResource(R.drawable.ic_slide_switch_off);
                    MCB.setValue(switchmain);
                    switchmain = 0;
                    relay1.setValue(false);
                    relay2.setValue(false);
                    relay3.setValue(false);
                    relay4.setValue(false);
                }
            }
        });


        relay1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
               temp1 = dataSnapshot.getValue(Boolean.class);
                Log.d("firesale", "Value is: " + temp1);

                if(temp1==false) {
                    img1.setImageResource(R.drawable.ic_slide_switch_off);
                    temp1=true;
                }

                else
                {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    temp1=false;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });




        relay2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                temp2 = dataSnapshot.getValue(Boolean.class);
                Log.d("firesale", "Value is: " + temp1);

                if(temp2==false) {
                    img2.setImageResource(R.drawable.ic_slide_switch_off);
                    temp2=true;
                }

                else
                {
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    temp2=false;

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });



        relay3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                temp3 = dataSnapshot.getValue(Boolean.class);
                Log.d("firesale", "Value is: " + temp1);

                if(temp3==false) {
                    img3.setImageResource(R.drawable.ic_slide_switch_off);
                    temp3=true;
                }

                else
                {
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    temp3=false;

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });

        relay4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                temp4 = dataSnapshot.getValue(Boolean.class);
                Log.d("firesale", "Value is: " + temp1);

                if(temp4==false) {
                    img4.setImageResource(R.drawable.ic_slide_switch_off);
                    temp4=true;
                }

                else
                {
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    temp4=false;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp1) {
                    img1.setImageResource(R.drawable.ic_slide_switch_off);
                    temp1 = false;
                    relay1.setValue(temp1);
                }
                else
                {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    temp1=true;
                    relay1.setValue(temp1);
                }
            }
        });



        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(temp2) {
                    img2.setImageResource(R.drawable.ic_slide_switch_off);
                    temp2 = false;
                    relay2.setValue(temp2);
                }
                else
                {
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    temp2=true;
                    relay2.setValue(temp2);
                }
            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(temp3) {
                    img3.setImageResource(R.drawable.ic_slide_switch_off);
                    temp3 = false;
                    relay3.setValue(temp3);
                }
                else
                {
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    temp3=true;
                    relay3.setValue(temp3);
                }
            }
        });


        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp4==true) {
                    img4.setImageResource(R.drawable.ic_slide_switch_off);
                    temp4 = false;
                    relay4.setValue(temp4);
                }
                else
                {
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    temp4=true;
                    relay4.setValue(temp4);
                }
            }
        });


        /*editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("text1");
                text1.setValue("text1");


            }
        });
*/
    }
}
