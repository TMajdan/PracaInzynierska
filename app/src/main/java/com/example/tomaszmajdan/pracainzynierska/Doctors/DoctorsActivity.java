package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Animals.CustomAdapter;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseHelper;
import com.example.tomaszmajdan.pracainzynierska.Animals.Spacecraft;
import com.example.tomaszmajdan.pracainzynierska.Manifest;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorsActivity extends Activity {
    private FragmentManager fmanager;
    ImageView call;
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    private FirebaseDatabase mFirebaseInstance;
    ListView lv;
    private String userId;
    EditText animalnameTxt, gatunekTxt, rasaTxt, rokTxt, mascTxt, sexTxt;
    private FirebaseAuth firebaseAuth;
    static Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors3);
        fmanager = getFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        ft.replace(R.id.fragment, new FirebaseDoctorsHelper());
        ft.commit();
        //firebaseAuth = FirebaseAuth.getInstance();
        // FirebaseUser animal = firebaseAuth.getCurrentUser();
        // userId = animal.getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        db = mFirebaseInstance.getReference("/doctors");
        //INITIALIZE FIREBASE DB
        //db = FirebaseDatabase.getInstance().getReference();
        // helper = new FirebaseHelper(db);
        //ADAPTER
        // adapter = new CustomAdapter(this, helper.retrieve());
        //  lv.setAdapter(adapter);
        //  adapter.notifyDataSetChanged();




    }


}