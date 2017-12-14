package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tomaszmajdan.pracainzynierska.Animals.MyHolder;
import com.example.tomaszmajdan.pracainzynierska.Animals.PicassoClient;
import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;

import java.util.ArrayList;

/**
 * Created by tomas on 10.12.2017.
 */

public class CustomAdapterVisit extends BaseAdapter {
    Context c;
    ArrayList<Visits> visits;
    LayoutInflater inflater;


    public CustomAdapterVisit(Context c, ArrayList<Visits> visits) {
        this.c = c;
        this.visits = visits;
    }


    @Override
    public int getCount() {
        return visits.size();
    }

    @Override
    public Object getItem(int i) {
        return visits.get(i);
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
            convertview= inflater.inflate(R.layout.visitview_layout,viewGroup,false);

        }


        MyHolderVisit holder= new MyHolderVisit(convertview);


        String DB_URL= "https://pracainzynierska-dd3c1.firebaseio.com/doctors/"+ visits.get(i).getdoctor();
        FirebaseClientVisit fcv = new FirebaseClientVisit(c,DB_URL);
        fcv.getName(holder.doktor_id);
        fcv.getRoom(holder.room_id);

        String DB_URL2= "https://pracainzynierska-dd3c1.firebaseio.com/animals/"+ visits.get(i).getanimal();
        FirebaseClientVisit fcv2 = new FirebaseClientVisit(c,DB_URL2);
        fcv2.getName(holder.animal_id);

        holder.status_id.setText(visits.get(i).getstatus());
        holder.data_id.setText(visits.get(i).getdate());
        holder.godzina_id.setText(visits.get(i).gettime());
        holder.rodzaj_id.setText(visits.get(i).getrodzajwizyty());
        holder.opis_id.setText(visits.get(i).getopis());
        holder.zalecenia= (visits.get(i).getZalecenia());
        holder.recepta=(visits.get(i).getRecepty());





        return convertview;
    }
}