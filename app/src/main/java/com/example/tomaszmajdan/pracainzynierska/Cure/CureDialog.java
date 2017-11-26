package com.example.tomaszmajdan.pracainzynierska.Cure;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.example.tomaszmajdan.pracainzynierska.Visit.MyVisitActivity;

/**
 * Created by Tomasz Majdan on 12.11.2017.
 */

public class CureDialog extends AlertDialog {
    /**
     * Callback listener which observers user selection.
     */
    ClickInterface anInterface;

    TextView Id_Wizyta, Id_Powrot;
    Context mContext;

    public CureDialog(Context context) {
        super(context);
        mContext = context;
       // this.anInterface = (ClickInterface) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cure_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        CardView greekMode = (CardView) findViewById(R.id.greekMode);


        (findViewById(R.id.Id_MojeWizyty)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Activity Main = new  Activity();
                //Main.startActivity(new Intent(v.getContext(), MainActivity.class));
                Intent intent = new Intent(mContext, MyVisitActivity.class);
                mContext.startActivity(intent);

            }
        });



        (findViewById(R.id.Id_Wizyta)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Activity Main = new  Activity();
                //Main.startActivity(new Intent(v.getContext(), MainActivity.class));
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);

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
