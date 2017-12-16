package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseClient;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.firebase.client.Firebase;

/**
 * Created by tomas on 10.12.2017.
 */



public class MyHolderVisit {

    TextView doktor_id, status_id, data_id, godzina_id, room_id, animal_id, rodzaj_id, opis_id, receptaText, zaleceniaText,visit_id;
    Button zalView, ReceptView, okBtn,anulView,anulBtn;
    Dialog dialog;
    String zalecenia,recepta;



    public MyHolderVisit(final View itemView) {


        doktor_id = (TextView) itemView.findViewById(R.id.doktor_id);
        status_id = (TextView) itemView.findViewById(R.id.status_id);
        data_id = (TextView) itemView.findViewById(R.id.data_id);
        godzina_id = (TextView) itemView.findViewById(R.id.godzina_id);
        room_id = (TextView) itemView.findViewById(R.id.room_id);
        animal_id = (TextView) itemView.findViewById(R.id.animal_id);
        rodzaj_id = (TextView) itemView.findViewById(R.id.rodzaj_id);
        opis_id = (TextView) itemView.findViewById(R.id.opis_id);
        anulView = (Button) itemView.findViewById(R.id.anulView);
        ReceptView = (Button) itemView.findViewById(R.id.recView);
        zalView = (Button) itemView.findViewById(R.id.zalView);
        visit_id = (TextView) itemView.findViewById(R.id.visit_id);
        //Code Snippet For Alert Dialog With Action


        ReceptView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayDialog2(recepta);

            }
        });

        zalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayDialog(zalecenia);

            }
        });

        anulView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancelDialog(visit_id);

            }
        });

    }

    private void displayDialog(String zalecenia) {
        dialog = MyVisitActivity.dialog;
        dialog.setContentView(R.layout.dialog_zalecenia);
        zaleceniaText = (TextView) dialog.findViewById(R.id.zalText);
        zaleceniaText.setText(zalecenia);
        okBtn = (Button) dialog.findViewById(R.id.okBtn);
        dialog.show();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    private void displayDialog2(String recepta) {
        dialog = MyVisitActivity.dialog;
        dialog.setContentView(R.layout.dialog_recepty);
        receptaText = (TextView) dialog.findViewById(R.id.recText);
        receptaText.setText(recepta);
        okBtn = (Button) dialog.findViewById(R.id.okBtn);
        dialog.show();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    private void cancelDialog(final TextView visit_id) {
        dialog = MyVisitActivity.dialog;
        dialog.setContentView(R.layout.dialog_anuluj);

        okBtn = (Button) dialog.findViewById(R.id.okBtn2);
        anulBtn = (Button) dialog.findViewById(R.id.okBtn);
        dialog.show();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DB_URL= "https://pracainzynierska-dd3c1.firebaseio.com/visits/"+visit_id.getText().toString();
                Firebase firebase = new Firebase(DB_URL);

                firebase.removeValue();
                dialog.dismiss();





            }
        });
       anulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }


}


