package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tomaszmajdan.pracainzynierska.R;
import com.example.tomaszmajdan.pracainzynierska.ClinicDoctors.MyDoctorsActivity;
import com.firebase.client.Firebase;

/**
 * Created by tomas on 17.12.2017.
 */

public class MyHolderDoctors{

    TextView textView_name, textView_desc, textView_room, textView_phone,textView_godz;
    TextView poniedzialek,wtorek,sroda,czwartek,piatek,sobota;
    Button okBtn,harmonogram;
    String p,w,s,cz,pi,sob;
    ImageView imageView_phonecall;
    Dialog dialog;


    public MyHolderDoctors(final View itemView) {


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

                DialogHarmonogram(p,w,s,cz,pi,sob);

            }
        });

        imageView_phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callMethod();

            }
        });

    }

    private void callMethod() {

        imageView_phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                view.getContext().startActivity(callIntent.setData(Uri.parse("tel:" +textView_phone.getText().toString())));
            }
        });

    }

    private void DialogHarmonogram(String p,String w, String s, String cz, String pi,String sob) {
        dialog = MyDoctorsActivity.dialog;
        dialog.setContentView(R.layout.dialog_harmonogram);
        poniedzialek = (TextView) dialog.findViewById(R.id.ponTxt);
        wtorek = (TextView) dialog.findViewById(R.id.wtorTxt);
        sroda = (TextView) dialog.findViewById(R.id.srodTxt);
        czwartek = (TextView) dialog.findViewById(R.id.czwTxt);
        piatek = (TextView) dialog.findViewById(R.id.piatTxt);
        sobota = (TextView) dialog.findViewById(R.id.sobTxt);


            poniedzialek.setText(p);
            wtorek.setText(w);
            sroda.setText(s);
            czwartek.setText(cz);
            piatek.setText(pi);
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
