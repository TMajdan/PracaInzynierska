package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tomaszmajdan.pracainzynierska.R;

import java.util.ArrayList;

/**
 * Created by Admin on 5/26/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Dog> dogies;
    LayoutInflater inflater;


    public CustomAdapter(Context c, ArrayList<Dog> dogies) {
        this.c = c;
        this.dogies = dogies;
    }





    @Override
    public int getCount() {
        return dogies.size();
    }

    @Override
    public Object getItem(int i) {
        return dogies.get(i);
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
            convertview= inflater.inflate(R.layout.listview_layout,viewGroup,false);

        }

        MyHolder holder= new MyHolder(convertview);
        holder.nameTxt.setText(dogies.get(i).getName());
        holder.sexTxt.setText(dogies.get(i).getSex());
        holder.rokTxt.setText(dogies.get(i).getRok());
        holder.gatunekTxt.setText(dogies.get(i).getGatunek());
        holder.mascTxt.setText(dogies.get(i).getMasc());
        holder.rasaTxt.setText(dogies.get(i).getRasa());

        PicassoClient.downloadimg(c,dogies.get(i).getUrl(),holder.img);


        return convertview;
    }
}
