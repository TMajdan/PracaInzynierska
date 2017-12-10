package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.R;

/**
 * Created by tomas on 10.12.2017.
 */

public class MyHolderVisit {

    TextView doktor_id, status_id, data_id,godzina_id,room_id,animal_id,rodzaj_id,opis_id;

    public  MyHolderVisit(View itemView) {


        doktor_id= (TextView) itemView.findViewById(R.id.doktor_id);
        status_id = (TextView) itemView.findViewById(R.id.status_id);
        data_id = (TextView) itemView.findViewById(R.id.data_id);
        godzina_id = (TextView) itemView.findViewById(R.id.godzina_id);
        room_id = (TextView) itemView.findViewById(R.id.room_id);
        animal_id = (TextView) itemView.findViewById(R.id.animal_id);
        rodzaj_id = (TextView) itemView.findViewById(R.id.rodzaj_id);
        opis_id= (TextView) itemView.findViewById(R.id.opis_id);




    }
}
