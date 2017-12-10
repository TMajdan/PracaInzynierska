package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseClient;
import com.example.tomaszmajdan.pracainzynierska.R;

/**
 * Created by tomas on 25.11.2017.
 */

public class VisitViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView textView_name, textView_room,textView_godz, texView_date, texView_opis, texView_animal, texView_status, texView_rodzaj;
    Button ReceptView, zalView;
    ImageView imageView_phonecall;
    static Context c;

    static public void setContext(Context context) {
        c = context;
    }

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
        Button ReceptView = (Button) itemView.findViewById(R.id.recView);
        Button zalView = (Button) itemView.findViewById(R.id.zalView);
        //Code Snippet For Alert Dialog With Action

        ReceptView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(mView.getContext());
                alert.setTitle("Recepta");
                alert.setMessage("Przykładowa recepta");
// Create TextView
                final TextView input = new TextView (mView.getContext());
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        input.setText("hi");
                        // Do something with value!
                    }
                });

                alert.show();
            }
        });


        zalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(mView.getContext());
                alert.setTitle("Zalecenia lekarskie");
                alert.setMessage("Przykładowe zalecenie");
// Create TextView
                final TextView input = new TextView (mView.getContext());
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        input.setText("hi");
                        // Do something with value!
                    }
                });

                alert.show();
            }
        });


    }
    public void set_Name(String name)
    {
        String DB_URL= "https://pracainzynierska-f1b54.firebaseio.com/doctors/" + name;
        FirebaseClient fc = new FirebaseClient(c, DB_URL);
        fc.getName(textView_name);
        fc.getRoom(textView_room);
    }

    public void setGodz(String godz) { textView_godz.setText(godz);}
    public void setDate(String date) { texView_date.setText(date);}
    public void setOpis(String opis) { texView_opis.setText(opis);}
    public void setAnimal(String animal) {
        String DB_URL= "https://pracainzynierska-f1b54.firebaseio.com/animals/" + animal;
        FirebaseClient fc = new FirebaseClient(c, DB_URL);
        fc.getName(texView_animal);
    }
    public void setStatus(String status) { texView_status.setText(status);}
    public void setRodzaj(String rodzaj) { texView_rodzaj.setText(rodzaj);}

}