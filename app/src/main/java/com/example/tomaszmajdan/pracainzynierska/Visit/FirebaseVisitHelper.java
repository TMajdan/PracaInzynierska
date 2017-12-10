package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tomaszmajdan.pracainzynierska.Visit.VisitViewHolder;
import com.example.tomaszmajdan.pracainzynierska.Visit.Visits;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by tomas on 25.11.2017.
 */

public class FirebaseVisitHelper extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    private FirebaseAuth firebaseAuth;
    private String userId;
    private FirebaseDatabase mFirebaseInstance;


    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle b)
    {
        final View view=inflater.inflate(R.layout.activity_my_visit2,group,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myref= FirebaseDatabase.getInstance().getReference().child("/visits");
       // firebaseAuth = FirebaseAuth.getInstance();
      //  FirebaseUser animal = firebaseAuth.getCurrentUser();
      //  userId = animal.getUid();
      //  mFirebaseInstance = FirebaseDatabase.getInstance();



        FirebaseRecyclerAdapter<Visits,VisitViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<Visits,VisitViewHolder>(
                Visits.class,
                R.layout.activity_my_visit,
                VisitViewHolder.class,
                myref
        )


        {
            @Override
            protected void populateViewHolder(VisitViewHolder viewHolder, Visits model, int position) {
                viewHolder.set_Name(model.getDoctor());
                viewHolder.setAnimal(model.getAnimal());
                viewHolder.setGodz(model.getTime());
                viewHolder.setDate(model.getDate());
                viewHolder.setStatus(model.getStatus());
                viewHolder.setOpis(model.getOpis());
                viewHolder.setRodzaj(model.getRodzajwizyty());


            }
        };



        recyclerView.setAdapter(recyclerAdapter);
        return view;



    }



}