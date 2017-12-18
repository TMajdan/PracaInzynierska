package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tomaszmajdan.pracainzynierska.R;

import java.util.ArrayList;

/**
 * Created by tomas on 17.12.2017.
 */

public class CustomAdapterDoctors extends BaseAdapter {
    Context c;
    ArrayList<Doc> docs;
    LayoutInflater inflater;


    public CustomAdapterDoctors(Context c, ArrayList<Doc> docs) {
        this.c = c;
        this.docs = docs;
    }


    @Override
    public int getCount() {
        return docs.size();
    }

    @Override
    public Object getItem(int i) {
        return docs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (inflater== null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } if(convertview==null)
        {
            convertview= inflater.inflate(R.layout.activity_doctors,viewGroup,false);

        }


        MyHolderDoctors holder= new MyHolderDoctors(convertview);



        holder.textView_name.setText(docs.get(i).getName());
        holder.textView_desc.setText(docs.get(i).getDesc());
        holder.textView_godz.setText(docs.get(i).getGodz());
        holder.textView_room.setText(docs.get(i).getRoom());
        holder.textView_phone.setText(docs.get(i).getPhone());

        holder.drWorkMonday = (docs.get(i).getdrWorkMonday());
        holder.drWorkTuesday = (docs.get(i).getdrWorkTuesday());
        holder.drWorkWednesday = (docs.get(i).getdrWorkWednesday());
        holder.drWorkThursday = (docs.get(i).getdrWorkThursday());
        holder.drWorkFriday = (docs.get(i).getdrWorkFriday());
        holder.drWorkSaturday= (docs.get(i).getdrWorkSaturday());


        return convertview;

    }
}