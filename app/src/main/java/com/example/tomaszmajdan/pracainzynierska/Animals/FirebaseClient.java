package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.content.Context;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.Visit.CustomAdapterVisit;
import com.example.tomaszmajdan.pracainzynierska.Visit.SendVisit;
import com.example.tomaszmajdan.pracainzynierska.Visit.Visits;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Admin on 5/26/2017.
 */

public class FirebaseClient  {

    Context c;



    String DB_URL;
    ListView listView;
    Firebase firebase;
    ArrayList<Dog> dogies= new ArrayList<>();
    ArrayList<Visits> visits = new ArrayList<>();
    CustomAdapter customAdapter;
    CustomAdapterVisit customAdapterVisit;

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public  FirebaseClient(Context c, String DB_URL, ListView listView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.listView= listView;


        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }


    public  FirebaseClient(Context c, String DB_URL)
    {
        this.c= c;
        this.DB_URL= DB_URL;

        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }


    public  void savedata(String name, String url, String gatunek, String sex, String rasa, String rok, String masc)
    {
        Dog d= new Dog();
        d.setName(name); //NAZWA
        d.setUrl(url); // URL
        d.setGatunek(rasa); //GATUNEK
        d.setSex(gatunek); //SEX
        d.setRasa(masc); //RASA
        d.setRok(sex); //ROK
        d.setMasc(rok);  //MASC

        firebase.push().setValue(d);


    }

    public void saveVisit(String doctor, String animal, String date, String time, String rodzajwizyty, String opis, String status){
        SendVisit s = new SendVisit();
        s.setAnimal(animal);
        s.setDate(date);
        s.setDoctor(doctor);
        s.setOpis(opis);
        s.setRodzajwizyty(rodzajwizyty);
        s.setTime(time);
        s.setStatus(status);

        String push = firebase.push().getKey();
        firebase.child(push).setValue(s);
        Object o = push;
        Firebase firebase1 = new Firebase("https://pracainzynierska-dd3c1.firebaseio.com/users/" + MainActivity.userID + "/visits/" + push);
        firebase1.setValue(o);
    }

    public  void refreshdata()
    {
        firebase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getupdates(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getupdates(DataSnapshot dataSnapshot){

        dogies.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Dog d= new Dog();
            d.setName(ds.getValue(Dog.class).getName());
            d.setSex(ds.getValue(Dog.class).getSex());
            d.setGatunek(ds.getValue(Dog.class).getGatunek());
            d.setRasa(ds.getValue(Dog.class).getRasa());
            d.setRok(ds.getValue(Dog.class).getRok());
            d.setMasc(ds.getValue(Dog.class).getMasc());
            d.setUrl(ds.getValue(Dog.class).getUrl());
            dogies.add(d);

        }
        if(dogies.size()>0)
        {
            customAdapter=new CustomAdapter(c, dogies);
            listView.setAdapter((ListAdapter) customAdapter);
        }else
        {
            Toast.makeText(c, "Brak utworzonych zwierząt!", Toast.LENGTH_SHORT).show();
        }
    }




    public  void refreshdataVisits()
    {

        firebase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                getupdatesVisits(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getupdatesVisits(DataSnapshot dataSnapshot){

        visits.clear();

        for(DataSnapshot ds2 :dataSnapshot.getChildren()){
            Visits v = new Visits();
            v.setdoctor(ds2.getValue(Visits.class).getdoctor());
            v.setroom(ds2.getValue(Visits.class).getroom());
            v.settime(ds2.getValue(Visits.class).gettime());
            v.setdate(ds2.getValue(Visits.class).getdate());
            v.setopis(ds2.getValue(Visits.class).getopis());
            v.setanimal(ds2.getValue(Visits.class).getanimal());
            v.setstatus(ds2.getValue(Visits.class).getstatus());
            v.setrodzajwizyty(ds2.getValue(Visits.class).getrodzajwizyty());

            visits.add(v);



        }
        if(visits.size()>0)
        {
            customAdapterVisit=new CustomAdapterVisit(c, visits);
            listView.setAdapter((ListAdapter) customAdapterVisit);
        }else
        {
            Toast.makeText(c, "Brak umówionych wizyt!", Toast.LENGTH_SHORT).show();
        }
    }



}
