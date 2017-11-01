package com.example.tomaszmajdan.pracainzynierska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Cure.Cure_Activity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private TextView okienko1,okienko2,okienko5,okienko6;
    private String userID;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        okienko1 = (TextView) findViewById(R.id.okienko1);
        okienko2 = (TextView) findViewById(R.id.okienko2);
        okienko5 = (TextView) findViewById(R.id.okienko5);
        okienko6 = (TextView) findViewById(R.id.okienko6);


        (findViewById(R.id.okienko1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Cure_Activity.class));
            }
        });

        (findViewById(R.id.okienko2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), AnimalActivity.class));
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
