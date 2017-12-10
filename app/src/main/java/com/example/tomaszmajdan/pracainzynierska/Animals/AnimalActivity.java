package com.example.tomaszmajdan.pracainzynierska.Animals;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.example.tomaszmajdan.pracainzynierska.UserEdit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnimalActivity extends Activity {
    //String userId;
    final static  String DB_URL= "https://pracainzynierska-f1b54.firebaseio.com/animals/" + MainActivity.userID;
    EditText nameeditText,urleditText,sexText,rokText,gatunekText,mascText,rasaText;
    Button btnsave;
    ListView listView;
    FirebaseClient firebaseClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.listview);
        firebaseClient= new FirebaseClient(this, DB_URL,listView);
        firebaseClient.refreshdata();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();

            }
        });
    }

    private void displayDialog()
    {
        Dialog d= new Dialog(this);
        d.setTitle("Zapisano!");
        d.setContentView(R.layout.customdialog_layout);
        nameeditText= (EditText)d.findViewById(R.id.nameEditText);
        sexText = (EditText)d.findViewById(R.id.sexEditText);
        rokText = (EditText)d.findViewById(R.id.rokEditText);
        gatunekText = (EditText)d.findViewById(R.id.gatunekEditText);
        mascText = (EditText)d.findViewById(R.id.mascEditText);
        rasaText = (EditText)d.findViewById(R.id.rasaEditText);
        urleditText=(EditText)d.findViewById(R.id.urlEditText);

        btnsave= (Button)d.findViewById(R.id.saveBtn);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseClient.savedata(
                        nameeditText.getText().toString(),
                        urleditText.getText().toString(),
                        sexText.getText().toString(),
                        rokText.getText().toString(),
                        gatunekText.getText().toString(),
                        mascText.getText().toString(),
                        rasaText.getText().toString()
                );

                nameeditText.setText("");
                urleditText.setText("");
                sexText.setText("");
                rokText.setText("");
                gatunekText.setText("");
                mascText.setText("");
                rasaText.setText("");

            }
        });

        d.show();

    }




}