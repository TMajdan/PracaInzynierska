package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.R;
import com.example.tomaszmajdan.pracainzynierska.Visit.MyVisitActivity;


/**
 * Created by Tomasz Majdan on 04.11.2017.
 */

public class DoctorsViewHolder extends RecyclerView.ViewHolder {
    Context mContext;
    View mView;
    TextView textView_name, textView_desc, textView_room, textView_phone,textView_godz;
    TextView poniedzialek,wtorek,sroda,czwartek,piatek,sobota;
    Button okBtn,harmonogram;
    String p,w,s,c,pi,sob;
    private String telephone;
    Dialog dialog;

    ImageView imageView_phonecall;
    public DoctorsViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
        textView_name = (TextView)itemView.findViewById(R.id.doctor_name);
        textView_desc = (TextView) itemView.findViewById(R.id.doctor_desc);
        textView_phone = (TextView) itemView.findViewById(R.id.doctor_phone);
        textView_room = (TextView) itemView.findViewById(R.id.nr_room);
        textView_godz = (TextView) itemView.findViewById(R.id.godz_wizyt);
        imageView_phonecall = (ImageView) itemView.findViewById(R.id.phonecall);

        harmonogram = (Button) itemView.findViewById(R.id.harmonogram);

        harmonogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogHarmonogram(p,w,s,c,pi,sob);

            }
        });




        imageView_phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callMethod();

            }
        });
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



    private void callMethod() {

        imageView_phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Intent intent = new Intent(callIntent.setData(Uri.parse("tel:" +textView_phone.getText().toString())));
                mContext.startActivity(intent);
            }
        });

    }

    private void DialogHarmonogram(String pon,String wtor, String srod, String czw, String piat,String sob) {
        dialog = DoctorsActivity.dialog;
        dialog.setContentView(R.layout.dialog_harmonogram);
        poniedzialek = (TextView) dialog.findViewById(R.id.ponTxt);
        wtorek = (TextView) dialog.findViewById(R.id.wtorTxt);
        sroda = (TextView) dialog.findViewById(R.id.srodTxt);
        czwartek = (TextView) dialog.findViewById(R.id.czwTxt);
        piatek = (TextView) dialog.findViewById(R.id.piatTxt);
        sobota = (TextView) dialog.findViewById(R.id.sobTxt);

        poniedzialek.setText(pon);
        wtorek.setText(wtor);
        sobota.setText(srod);
        czwartek.setText(czw);
        piatek.setText(piat);
        sobota.setText(sob);

        okBtn = (Button) dialog.findViewById(R.id.okBtn);
        dialog.show();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

}