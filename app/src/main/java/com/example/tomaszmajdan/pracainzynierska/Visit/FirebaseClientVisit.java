package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.Animals.CustomAdapter;
import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by tomas on 10.12.2017.
 */

public class FirebaseClientVisit {


    Context c;

    String DB_URL;
    ListView listView;
    Firebase firebase2;
    ArrayList<Visits> visits = new ArrayList<>();
    CustomAdapter customAdapter;
    CustomAdapterVisit customAdapterVisit;


    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public  FirebaseClientVisit(Context c, String DB_URL, ListView listView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.listView= listView;


        Firebase.setAndroidContext(c);
        firebase2=new Firebase(DB_URL);
    }

    public  FirebaseClientVisit(Context c, String DB_URL)
    {
        this.c= c;
        this.DB_URL= DB_URL;

        Firebase.setAndroidContext(c);
        firebase2=new Firebase(DB_URL);
    }

    public  void refreshdataVisits()
    {

        firebase2.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                getupdates(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void getupdates(DataSnapshot dataSnapshot){

        visits.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){

        if(ds.child("animal").getValue() != null && ds.child("animal").getValue().toString().contains(MainActivity.userID)) {
            Visits v = new Visits();
            v.setstatus(ds.getValue(Visits.class).getstatus());
            v.setdoctor(ds.getValue(Visits.class).getdoctor());
            v.setroom(ds.getValue(Visits.class).getroom());
            v.settime(ds.getValue(Visits.class).gettime());
            v.setdate(ds.getValue(Visits.class).getdate());
            v.setopis(ds.getValue(Visits.class).getopis());
            v.setanimal(ds.getValue(Visits.class).getanimal());
            v.setrodzajwizyty(ds.getValue(Visits.class).getrodzajwizyty());
             v.setZaleceniaUwagi(ds.getValue(Visits.class).getZaleceniaUwagi());
             v.setLek(ds.getValue(Visits.class).getLek());
             v.setDawkaLeku(ds.getValue(Visits.class).getDawkaLeku());
            v.setKey(ds.getKey());

            visits.add(v);

        }


        }
        if(visits.size()>0)
        {
            customAdapterVisit=new CustomAdapterVisit(c, visits);
            listView.setAdapter((ListAdapter) customAdapterVisit);
        }else
        {
            Toast.makeText(c, "Nie masz umówionej żadnej wizyty!", Toast.LENGTH_SHORT).show();
        }
    }

    TextView edit,edit2;
    public void getName(TextView edit1) {
        edit = edit1;

        firebase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object r = dataSnapshot.child("name").getValue();

                if(r != null) edit.setText(r.toString());


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getRoom(TextView edit1) {
        edit2 = edit1;

        firebase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object r = dataSnapshot.child("room").getValue();
                if(r != null) edit2.setText(r.toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }





}
