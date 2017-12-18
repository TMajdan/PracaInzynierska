package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tomaszmajdan.pracainzynierska.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ValueEventListener;

import static com.example.tomaszmajdan.pracainzynierska.R.id.phone;

/**
 * Created by Tomasz Majdan on 04.11.2017.
 */

public class FirebaseDoctorsHelper extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    //public String phonenumber;



    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle b)
    {
        final View view=inflater.inflate(R.layout.activity_doctors2,group,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myref= FirebaseDatabase.getInstance().getReference().child("/doctors");




        FirebaseRecyclerAdapter<Upcomings,DoctorsViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<Upcomings,DoctorsViewHolder>(
                Upcomings.class,
                R.layout.activity_doctors,
                DoctorsViewHolder.class,
                myref
        )




        {
            @Override
            protected void populateViewHolder(DoctorsViewHolder viewHolder, Upcomings model, int position) {

                    viewHolder.setDoctor_name(model.getName());
                    viewHolder.setDoctor_desc(model.getDesc());
                    viewHolder.setNr_room(model.getRoom());
                    viewHolder.setPhone_call(model.getPhone());
                    viewHolder.setGodz(model.getGodz());

                    viewHolder.setP(model.getP());
                    viewHolder.setW(model.getW());
                    viewHolder.setS(model.getS());
                    viewHolder.setC(model.getCz());
                    viewHolder.setPi(model.getPi());
                    viewHolder.setP(model.getP());

                }


        };



        recyclerView.setAdapter(recyclerAdapter);
        return view;



    }



}