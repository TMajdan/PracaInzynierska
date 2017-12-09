package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
    CustomAdapter customAdapter;


    public  FirebaseClient(Context c, String DB_URL, ListView listView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.listView= listView;


        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    public  void savedata(String name, String url, String gatunek, String sex, String rasa, String rok, String masc)
    {
        Dog d= new Dog();
        d.setName(name);
        d.setUrl(url);
        d.setGatunek(gatunek);
        d.setSex(sex);
        d.setRasa(rasa);
        d.setRok(rok);
        d.setMasc(masc);

        firebase.push().setValue(d);


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
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}