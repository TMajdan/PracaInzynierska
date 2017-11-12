package com.example.tomaszmajdan.pracainzynierska.Cure;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Doctors.DoctorsActivity;
import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.example.tomaszmajdan.pracainzynierska.UserEdit;

import org.w3c.dom.Text;

/**
 * Created by Tomasz Majdan on 12.11.2017.
 */

public class CureDialog extends AlertDialog {
    /**
     * Callback listener which observers user selection.
     */
    ClickInterface anInterface;

    TextView Id_Wizyta, Id_Powrot;

    public CureDialog(Context context) {
        super(context);
       // this.anInterface = (ClickInterface) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cure_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        CardView greekMode = (CardView) findViewById(R.id.greekMode);
        greekMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // anInterface.onSelect(CurrentMode.WIZYTA);
              //  dismiss();
            }
        });

        final CardView englishMode = (CardView) findViewById(R.id.englishMode);
        englishMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // anInterface.onSelect(CurrentMode.POWROT);

            }
        });


        (findViewById(R.id.Id_Wizyta)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity Main = new  Activity();
                Main.startActivity(new Intent(v.getContext(), MainActivity.class));


            }
        });






    }



    /**
     * Callback for when user clicks on either of the two modes.
     */
    public interface ClickInterface {
        void onSelect(CurrentMode currentMode);
    }
}
