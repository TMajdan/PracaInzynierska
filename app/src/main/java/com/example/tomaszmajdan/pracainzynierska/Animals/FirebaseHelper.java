package com.example.tomaszmajdan.pracainzynierska.Animals;

/**
 * Created by Tomasz Majdan on 21.10.2017.
 */
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1.SAVE DATA TO FIREBASE
 * 2. RETRIEVE
 * 3.RETURN AN ARRAYLIST
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    private FirebaseAuth firebaseAuth;
    private String userId;
    private FirebaseDatabase mFirebaseInstance;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(Spacecraft spacecraft)
    {
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser animal = firebaseAuth.getCurrentUser();
        userId = animal.getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        db = mFirebaseInstance.getReference("animal");
       // userId = db.push().getKey();
        if(spacecraft==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child(userId).push().setValue(spacecraft);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        spacecrafts.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Spacecraft spacecraft=ds.getValue(Spacecraft.class);
            spacecrafts.add(spacecraft);
        }
    }
    //RETRIEVE
    public ArrayList<Spacecraft> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return spacecrafts;
    }
}