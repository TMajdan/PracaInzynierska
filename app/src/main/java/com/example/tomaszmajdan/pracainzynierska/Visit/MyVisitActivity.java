package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tomaszmajdan.pracainzynierska.Animals.CustomAdapter;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseHelper;
import com.example.tomaszmajdan.pracainzynierska.Doctors.FirebaseDoctorsHelper;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyVisitActivity  extends Activity {
    private FragmentManager fmanager;
    ImageView call;
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    private FirebaseDatabase mFirebaseInstance;
    ListView lv;
    private String userId;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_visit3);
        fmanager = getFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        ft.replace(R.id.fragment, new FirebaseVisitHelper());
        ft.commit();
        //firebaseAuth = FirebaseAuth.getInstance();
        // FirebaseUser animal = firebaseAuth.getCurrentUser();
        // userId = animal.getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        db = mFirebaseInstance.getReference("/visits");
        //INITIALIZE FIREBASE DB
        //db = FirebaseDatabase.getInstance().getReference();
        // helper = new FirebaseHelper(db);
        //ADAPTER
        // adapter = new CustomAdapter(this, helper.retrieve());
        //  lv.setAdapter(adapter);
        //  adapter.notifyDataSetChanged();


    }
}
