package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnimalActivity extends AppCompatActivity {
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    private FirebaseDatabase mFirebaseInstance;
    ListView lv;
    private String userId;
    EditText animalnameTxt, gatunekTxt, rasaTxt,rokTxt,mascTxt,sexTxt;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //  setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.lv);
        firebaseAuth = FirebaseAuth.getInstance();
       // FirebaseUser animal = firebaseAuth.getCurrentUser();
       // userId = animal.getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        db = mFirebaseInstance.getReference("animal");
        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        //ADAPTER
        adapter = new CustomAdapter(this, helper.retrieve());
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {


                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });




    }


    //DISPLAY INPUT DIALOG
    private void displayInputDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.input_dialog);
        animalnameTxt = (EditText) d.findViewById(R.id.nameEditText);
        gatunekTxt = (EditText) d.findViewById(R.id.propellantEditText);
        rasaTxt = (EditText) d.findViewById(R.id.descEditText);
        sexTxt = (EditText) d.findViewById(R.id.nameEditText2);
        rokTxt = (EditText) d.findViewById(R.id.nameEditText3);
        mascTxt = (EditText) d.findViewById(R.id.nameEditText4);
        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);
        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String animalname = animalnameTxt.getText().toString();
                String gatunek = gatunekTxt.getText().toString();
                String rasa = rasaTxt.getText().toString();
                String sex = sexTxt.getText().toString();
                String rok = rokTxt.getText().toString();
                String masc = mascTxt.getText().toString();
                //SET DATA
                Spacecraft s = new Spacecraft();
                s.setAnimalname(animalname);
                s.setGatunek(gatunek);
                s.setRasa(rasa);
                s.setSex(sex);
                s.setRok(rok);
                s.setMasc(masc);
                //SIMPLE VALIDATION
                if (animalname != null && animalname.length() > 0) {
                    //THEN SAVE
                    if (helper.save(s)) {
                        //IF SAVED CLEAR EDITXT
                        animalnameTxt.setText("");
                        gatunekTxt.setText("");
                        rasaTxt.setText("");
                        sexTxt.setText("");
                        rokTxt.setText("");
                        mascTxt.setText("");
                        adapter = new CustomAdapter(AnimalActivity.this, helper.retrieve());
                        lv.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(AnimalActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }
}
