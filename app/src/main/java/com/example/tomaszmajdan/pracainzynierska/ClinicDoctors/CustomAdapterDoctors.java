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

        holder.p= (docs.get(i).getP());
        holder.w= (docs.get(i).getW());
        holder.s= (docs.get(i).getS());
        holder.cz= (docs.get(i).getCz());
        holder.pi= (docs.get(i).getPi());
        holder.sob= (docs.get(i).getSob());


        return convertview;

    }
}