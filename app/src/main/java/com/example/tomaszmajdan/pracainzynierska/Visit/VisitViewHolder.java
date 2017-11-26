package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.R;

/**
 * Created by tomas on 25.11.2017.
 */

public class VisitViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView textView_name, textView_room,textView_godz, texView_date, texView_opis, texView_animal, texView_status, texView_rodzaj;

    ImageView imageView_phonecall;
    public VisitViewHolder(View itemView) {
        super(itemView);
        mView=itemView;

        textView_name = (TextView)itemView.findViewById(R.id.doktor_id);
        //textView_phone = (TextView) itemView.findViewById(R.id.doctor_phone);
        textView_room = (TextView) itemView.findViewById(R.id.room_id);
        textView_godz = (TextView) itemView.findViewById(R.id.godzina_id);
        texView_date = (TextView) itemView.findViewById(R.id.data_id);
        texView_opis = (TextView) itemView.findViewById(R.id.opis_id);
        texView_animal = (TextView) itemView.findViewById(R.id.animal_id);
        texView_status = (TextView) itemView.findViewById(R.id.status_id);
        texView_rodzaj = (TextView) itemView.findViewById(R.id.rodzaj_id);
        //  imageView=(ImageView)itemView.findViewById(R.id.image);
    }
    public void set_Name(String name)
    {
        textView_name.setText(name);
    }

    //public void setPhone_call(String phone)
   // {
    //    textView_phone.setText(phone);
   // }
    public void setNr_room(String room)
    {
        textView_room.setText(room);
    }
    public void setGodz(String godz) { textView_godz.setText(godz);}
    public void setDate(String date) { texView_date.setText(date);}
    public void setOpis(String opis) { texView_opis.setText(opis);}
    public void setAnimal(String animal) { texView_animal.setText(animal);}
    public void setStatus(String status) { texView_status.setText(status);}
    public void setRodzaj(String rodzaj) { texView_rodzaj.setText(rodzaj);}

}