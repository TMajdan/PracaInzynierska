package com.example.tomaszmajdan.pracainzynierska;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Cure.CureDialog;
import com.example.tomaszmajdan.pracainzynierska.Cure.Cure_Activity;
import com.example.tomaszmajdan.pracainzynierska.Doctors.Doctors;
import com.example.tomaszmajdan.pracainzynierska.Doctors.DoctorsActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends Activity {


    private TextView okienko1,okienko2,okienko3,okienko5,okienko6;
    private String userID;
    private FirebaseAuth firebaseAuth;
    private SharedPreferences mPrefs;
    final String PREFS_NAME = "FlashPrefs";
    private Activity mActivity;
    private static final String VAL_FIRST_RUN = "first_run";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
         // Checks if app run for first time.
        final CureDialog dialog = new CureDialog(this);


        okienko1 = (TextView) findViewById(R.id.okienko1);
        okienko2 = (TextView) findViewById(R.id.okienko2);
        okienko3 = (TextView) findViewById(R.id.okienko3);
        okienko5 = (TextView) findViewById(R.id.okienko5);
        okienko6 = (TextView) findViewById(R.id.okienko6);



        (findViewById(R.id.okienko1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();
            }
        });

        (findViewById(R.id.okienko2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), AnimalActivity.class));
            }
        });

        (findViewById(R.id.okienko3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DoctorsActivity.class));
            }
        });

        (findViewById(R.id.okienko5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), UserEdit.class));
            }
        });



        (findViewById(R.id.okienko6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                //closing activity
                finish();
                //starting login activity
                startActivity(new Intent(v.getContext(), LoginActivity.class));
            }
        });
    }




}
