package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Doctors.Upcomings;
import com.example.tomaszmajdan.pracainzynierska.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by tomas on 25.11.2017.
 */

public class VisitsBaseAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Visits> visits;


    public VisitsBaseAdapter(Context context, ArrayList<Visits> visits) {
        this.c = context;
        this.visits = visits;
    }




    @Override
    public int getCount() {
        return visits.size();
    }
    @Override
    public Object getItem(int position) {
        return visits.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }




    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_my_visit,parent,false);
        }
        TextView imieTxt= (TextView) convertView.findViewById(R.id.doktor_id);
        TextView roomTxt= (TextView) convertView.findViewById(R.id.room_id);
        TextView godzTxt = (TextView) convertView.findViewById(R.id.godz_wizyt);
        TextView dateTxt = (TextView) convertView.findViewById(R.id.data_id);
        TextView opisTxt = (TextView) convertView.findViewById(R.id.opis_id);
        TextView animalTxt = (TextView) convertView.findViewById(R.id.animal_id);
        TextView statusTxt = (TextView) convertView.findViewById(R.id.status_id);
        TextView rodzajTxt = (TextView) convertView.findViewById(R.id.rodzaj_id);

        final Visits u= (Visits) this.getItem(position);
        imieTxt.setText(u.getName());
        roomTxt.setText(u.getRoom());
        godzTxt.setText(u.getGodz());
        dateTxt.setText(u.getDate());
        opisTxt.setText(u.getOpis());
        animalTxt.setText(u.getAnimal());
        statusTxt.setText(u.getStatus());
        rodzajTxt.setText(u.getRodzaj());

        return convertView;
    }

}