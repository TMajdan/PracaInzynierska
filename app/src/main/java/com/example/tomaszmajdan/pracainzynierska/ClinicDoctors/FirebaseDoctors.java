package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.tomaszmajdan.pracainzynierska.ClinicDoctors.CustomAdapterDoctors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by tomas on 17.12.2017.
 */

public class FirebaseDoctors {


    Context c;

    String DB_URL;
    ListView listView;
    Firebase firebase2;
    ArrayList<Doc> docs = new ArrayList<>();
    //CustomAdapter customAdapter;
    CustomAdapterDoctors customAdapterDoctors;


    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public FirebaseDoctors(Context c, String DB_URL, ListView listView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.listView= listView;


        Firebase.setAndroidContext(c);
        firebase2=new Firebase(DB_URL);
    }

    public  FirebaseDoctors(Context c, String DB_URL)
    {
        this.c= c;
        this.DB_URL= DB_URL;

        Firebase.setAndroidContext(c);
        firebase2=new Firebase(DB_URL);
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
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

        docs.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){

            //if(ds.child("doctors").getValue() != null && ds.child("animal").getValue().toString().contains(MainActivity.userID)) {
                Doc d = new Doc();
                d.setName(ds.getValue(Doc.class).getName());
                d.setDesc(ds.getValue(Doc.class).getDesc());
                d.setPhone(ds.getValue(Doc.class).getPhone());
                d.setGodz(ds.getValue(Doc.class).getGodz());
                d.setRoom(ds.getValue(Doc.class).getRoom());

            d.setP(ds.getValue(Doc.class).getP());
            d.setW(ds.getValue(Doc.class).getW());
            d.setS(ds.getValue(Doc.class).getS());
            d.setCz(ds.getValue(Doc.class).getCz());
            d.setPi(ds.getValue(Doc.class).getPi());
            d.setSob(ds.getValue(Doc.class).getSob());



                docs.add(d);

            }


        if(docs.size()>0)
        {
            customAdapterDoctors =new CustomAdapterDoctors(c, docs);
            listView.setAdapter((ListAdapter) customAdapterDoctors);
        }
        else
        {
            Toast.makeText(c, "Brak lekarzy!", Toast.LENGTH_SHORT).show();
        }
    }

}




