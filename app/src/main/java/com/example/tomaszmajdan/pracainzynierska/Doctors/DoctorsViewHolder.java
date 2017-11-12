package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.R;


/**
 * Created by Tomasz Majdan on 04.11.2017.
 */

public class DoctorsViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView textView_name, textView_desc, textView_room, textView_phone,textView_godz;

    ImageView imageView_phonecall;
    public DoctorsViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
        textView_name = (TextView)itemView.findViewById(R.id.doctor_name);
        textView_desc = (TextView) itemView.findViewById(R.id.doctor_desc);
        textView_phone = (TextView) itemView.findViewById(R.id.doctor_phone);
        textView_room = (TextView) itemView.findViewById(R.id.nr_room);
        textView_godz = (TextView) itemView.findViewById(R.id.godz_wizyt);
        //imageView_phonecall = (ImageView) itemView.findViewById(R.id.phonecall);

      //  imageView=(ImageView)itemView.findViewById(R.id.image);
    }
    public void setDoctor_name(String name)
    {
        textView_name.setText(name);
    }
    public void setDoctor_desc(String desc)
    {
        textView_desc.setText(desc);
    }
    public void setPhone_call(String phone)
    {
        textView_phone.setText(phone);
    }
    public void setNr_room(String room)
    {
        textView_room.setText(room);
    }
    public void setGodz(String godz) { textView_godz.setText(godz);}




}
