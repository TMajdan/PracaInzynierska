package com.example.tomaszmajdan.pracainzynierska.Cure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;

public class Cure_Activity extends AppCompatActivity {

    TextView BacktoMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure_);


        BacktoMain = (TextView) findViewById(R.id.BackMode);


        (findViewById(R.id.BackMode)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }


}
