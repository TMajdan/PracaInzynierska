package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tomaszmajdan.pracainzynierska.Animals.CustomAdapter;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseClient;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseHelper;
import com.example.tomaszmajdan.pracainzynierska.Doctors.FirebaseDoctorsHelper;
import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyVisitActivity  extends Activity {
    //final static  String DB_URL= "https://pracainzynierska-f1b54.firebaseio.com/visits/" + MainActivity.userID;
    final static  String DB_URL= "https://pracainzynierska-dd3c1.firebaseio.com/visits";
    ListView listView;

    FirebaseClientVisit firebaseClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_visit2);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);



        listView=(ListView)findViewById(R.id.listview);
        firebaseClient= new FirebaseClientVisit(this, DB_URL,listView);
        firebaseClient.refreshdataVisits();

    }
}
