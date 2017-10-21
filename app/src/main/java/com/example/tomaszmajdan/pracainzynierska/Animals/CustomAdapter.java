package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tomaszmajdan.pracainzynierska.R;

import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */
public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Spacecraft> spacecrafts;
    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }
    @Override
    public int getCount() {
        return spacecrafts.size();
    }
    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }
        TextView imieTxt= (TextView) convertView.findViewById(R.id.nameTxt);

        TextView sexTxt= (TextView) convertView.findViewById(R.id.descTxt);

        TextView gatunekTxt= (TextView) convertView.findViewById(R.id.descTxt2);

        TextView rokTxt = (TextView) convertView.findViewById(R.id.descTxt3);

        TextView rasaTxt = (TextView) convertView.findViewById(R.id.descTxt4);

        TextView mascTxt = (TextView) convertView.findViewById(R.id.propellantTxt);

        final Spacecraft s= (Spacecraft) this.getItem(position);
        imieTxt.setText(s.getAnimalname());
        sexTxt.setText(s.getSex());
        gatunekTxt.setText(s.getGatunek());
        rokTxt.setText(s.getRok());
        rasaTxt.setText(s.getRasa());
        mascTxt.setText(s.getMasc());

        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,s.getAnimalname(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}