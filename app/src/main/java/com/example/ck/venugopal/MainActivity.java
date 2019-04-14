package com.example.ck.venugopal;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    int switchmain,i;
    boolean temp1,temp2,temp3,temp4;
    Switch switch1;
    ImageView img1,img2,img3,img4;
    Button watch1,watch2,watch3,watch4,edit1,edit2,edit3,edit4;
    TextView textView1,textView2,textView3,textView4,name1,name2,name3,name4;
    String OFF="OFF",ON="ON";
    final Context c = this;
    String tempname1,tempname2,tempname3,tempname4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference  MCB   = database.getReference("switchmain");

    DatabaseReference relay1 = database.getReference("relay1");
    DatabaseReference relay2 = database.getReference("relay2");
    DatabaseReference relay3 = database.getReference("relay3");
    DatabaseReference relay4 = database.getReference("relay4");

    DatabaseReference name1text = database.getReference("name1");
    DatabaseReference name2text = database.getReference("name2");
    DatabaseReference name3text = database.getReference("name3");
    DatabaseReference name4text = database.getReference("name4");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startService(new Intent(this, BackgroundService.class));


        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        switch1 = findViewById(R.id.switch1);


        textView1 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView6);
        textView3 = findViewById(R.id.textView5);
        textView4 = findViewById(R.id.textView);


        watch1 = findViewById(R.id.watch1);
        watch2 = findViewById(R.id.watch2);
        watch3 = findViewById(R.id.watch3);
        watch4 = findViewById(R.id.watch4);



        name1 = findViewById(R.id.Relay1);
        name2 = findViewById(R.id.Relay2);
        name3 = findViewById(R.id.Relay3);
        name4 = findViewById(R.id.Relay4);


        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);



        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchmain==0) {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    textView1.setText(ON);
                    textView2.setText(ON);
                    textView3.setText(ON);
                    textView4.setText(ON);
                    MCB.setValue(switchmain);
                    switchmain = 1;
                    relay1.setValue(true);
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
                    textView1.setText(OFF);
                    textView2.setText(OFF);
                    textView3.setText(OFF);
                    textView4.setText(OFF);

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
                    textView1.setText(OFF);
                    temp1=true;
                }

                else
                {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    textView1.setText(ON);
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
                Log.d("firesale", "Value is: " + temp2);

                if(temp2==false) {
                    img2.setImageResource(R.drawable.ic_slide_switch_off);
                    textView2.setText(OFF);
                    temp2=true;
                }

                else
                {
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    textView2.setText(ON);
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
                    textView3.setText(OFF);
                    temp3=true;
                }

                else
                {
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    textView3.setText(ON);
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
                    textView4.setText(OFF);
                    temp4=true;
                }

                else
                {
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    textView4.setText(ON);
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

                if(temp1==true) {
                    img1.setImageResource(R.drawable.ic_slide_switch_off);
                    textView1.setText(OFF);
                    temp1 = false;
                    relay1.setValue(temp1);
                }
                else
                {
                    img1.setImageResource(R.drawable.ic_slide_switch_on);
                    textView1.setText(ON);
                    temp1=true;
                    relay1.setValue(temp1);
                }
            }
        });



        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(temp2==true) {
                    img2.setImageResource(R.drawable.ic_slide_switch_off);
                    textView2.setText(OFF);
                    temp2 = false;
                    relay2.setValue(temp2);
                }
                else
                {
                    img2.setImageResource(R.drawable.ic_slide_switch_on);
                    textView2.setText(ON);
                    temp2=true;
                    relay2.setValue(temp2);
                }
            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(temp3==true) {
                    img3.setImageResource(R.drawable.ic_slide_switch_off);
                    textView3.setText(OFF);
                    temp3 = false;
                    relay3.setValue(temp3);
                }
                else
                {
                    img3.setImageResource(R.drawable.ic_slide_switch_on);
                    textView3.setText(ON);
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
                    textView4.setText(OFF);
                    temp4 = false;
                    relay4.setValue(temp4);
                }
                else
                {
                    img4.setImageResource(R.drawable.ic_slide_switch_on);
                    textView4.setText(ON);
                    temp4=true;
                    relay4.setValue(temp4);
                }
            }
        });


        watch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                                int hello =Integer.parseInt( userInputDialogEditText.getText().toString());
                                hello=hello*60000;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        img1.setImageResource(R.drawable.ic_slide_switch_off);
                                        textView1.setText(OFF);
                                        temp1=false;
                                        relay1.setValue(temp1);
                                      //  Toast.makeText(MainActivity.this,"Hellllllllllllllooooooooooooooooooooo",Toast.LENGTH_SHORT).show();
                                    }
                                },hello);
                                img1.setImageResource(R.drawable.ic_slide_switch_on);
                                textView1.setText(ON);
                                temp1=true;
                                relay1.setValue(temp1);


                              //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        watch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                                int hello =Integer.parseInt( userInputDialogEditText.getText().toString());
                                hello=hello*60000;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        img2.setImageResource(R.drawable.ic_slide_switch_off);
                                        textView2.setText(OFF);
                                        temp2=false;
                                        relay2.setValue(temp2);
                                        //  Toast.makeText(MainActivity.this,"Hellllllllllllllooooooooooooooooooooo",Toast.LENGTH_SHORT).show();
                                    }
                                },hello);
                                img2.setImageResource(R.drawable.ic_slide_switch_on);
                                textView2.setText(ON);
                                temp2=true;
                                relay2.setValue(temp2);


                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        watch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                                int hello =Integer.parseInt( userInputDialogEditText.getText().toString());
                                hello=hello*60000;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        img3.setImageResource(R.drawable.ic_slide_switch_off);
                                        textView3.setText(OFF);
                                        temp3=false;
                                        relay3.setValue(temp3);
                                        //  Toast.makeText(MainActivity.this,"Hellllllllllllllooooooooooooooooooooo",Toast.LENGTH_SHORT).show();
                                    }
                                },hello);
                                img3.setImageResource(R.drawable.ic_slide_switch_on);
                                textView3.setText(ON);
                                temp3=true;
                                relay1.setValue(temp3);


                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        watch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                                int hello =Integer.parseInt( userInputDialogEditText.getText().toString());
                                hello=hello*60000;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        img4.setImageResource(R.drawable.ic_slide_switch_off);
                                        textView4.setText(OFF);
                                        temp4=false;
                                        relay4.setValue(temp4);
                                        //  Toast.makeText(MainActivity.this,"Hellllllllllllllooooooooooooooooooooo",Toast.LENGTH_SHORT).show();
                                    }
                                },hello);

                                img4.setImageResource(R.drawable.ic_slide_switch_on);
                                textView4.setText(ON);
                                temp4=true;
                                relay4.setValue(temp4);


                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        name1text.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                tempname1 = dataSnapshot.getValue(String.class);
                    name1.setText(tempname1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });



        name2text.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                tempname2 = dataSnapshot.getValue(String.class);
                name2.setText(tempname2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });

        name3text.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                tempname3 = dataSnapshot.getValue(String.class);
                name3.setText(tempname3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });

        name4text.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                tempname4 = dataSnapshot.getValue(String.class);
                name4.setText(tempname4);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firesale", "Failed to read value.", error.toException());
            }
        });



        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box_name, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // Get user input here
                                String ButtonName1 = userInputDialogEditText.getText().toString();

                                        name1.setText(ButtonName1);
                                        name1text.setValue(ButtonName1);

                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })


                        .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });


        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box_name, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // Get user input here
                                String ButtonName2 = userInputDialogEditText.getText().toString();

                                name2.setText(ButtonName2);
                                name2text.setValue(ButtonName2);

                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });


        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box_name, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // Get user input here
                                String ButtonName3 = userInputDialogEditText.getText().toString();

                                name3.setText(ButtonName3);
                                name3text.setValue(ButtonName3);

                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });

        edit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box_name, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // Get user input here
                                String ButtonName4 = userInputDialogEditText.getText().toString();

                                name4.setText(ButtonName4);
                                name4text.setValue(ButtonName4);

                                //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                            }
                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });







    }



    public void kuchbhi(){
        {
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
            View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
            alertDialogBuilderUserInput.setView(mView);

            final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
            alertDialogBuilderUserInput
                    .setCancelable(false)
                    .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogBox, int id) {
                            // ToDo get user input here
                            int hello =Integer.parseInt( userInputDialogEditText.getText().toString());
                            hello=hello*60000;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    img1.setImageResource(R.drawable.ic_slide_switch_off);
                                    textView1.setText(OFF);
                                    temp1=false;
                                    relay1.setValue(temp1);
                                    //  Toast.makeText(MainActivity.this,"Hellllllllllllllooooooooooooooooooooo",Toast.LENGTH_SHORT).show();
                                }
                            },hello);
                            img1.setImageResource(R.drawable.ic_slide_switch_on);
                            textView1.setText(ON);
                            temp1=true;
                            relay1.setValue(temp1);


                            //  Toast.makeText(MainActivity.this,hello,Toast.LENGTH_SHORT).show();
                        }
                    })

                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {
                                    dialogBox.cancel();
                                }
                            });

            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            alertDialogAndroid.show();
        }
    }
}
