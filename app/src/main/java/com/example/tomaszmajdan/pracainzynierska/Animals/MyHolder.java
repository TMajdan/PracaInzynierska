package com.example.tomaszmajdan.pracainzynierska.Animals;

/**
 * Created by tomas on 09.12.2017.
 */

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.R;

public class MyHolder {

    TextView nameTxt,sexTxt,rokTxt,gatunekTxt,mascTxt,rasaTxt;
    ImageView img;
    public MyHolder(View itemView) {


        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        sexTxt = (TextView) itemView.findViewById(R.id.sexTxt);
        rokTxt = (TextView) itemView.findViewById(R.id.rokTxt);
        gatunekTxt = (TextView) itemView.findViewById(R.id.gatunekTxt);
        mascTxt = (TextView) itemView.findViewById(R.id.mascTxt);
        rasaTxt = (TextView) itemView.findViewById(R.id.rasaTxt);
        img=(ImageView) itemView.findViewById(R.id.dogimage);


    }
}