package com.example.tomaszmajdan.pracainzynierska.Visit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Animals.FirebaseClient;
import com.example.tomaszmajdan.pracainzynierska.Doctors.DoctorsActivity;
import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.example.tomaszmajdan.pracainzynierska.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VisitAppointment extends Activity {
    final static  String DB_URL= "https://pracainzynierska-dd3c1.firebaseio.com/visits/";
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth firebaseAuth;
    private String userId;
    private String[] doctors = new String[]{};
    private String[] animals = new String[]{};
    private String[] visits;
    private FirebaseDatabase mFirebaseInstance2;
    private DatabaseReference mFirebaseDatabase2;
    private DatabaseReference saveFirebaseDatabase;
    private String[] doc = new String[]{};
    private String[] anime = new String[]{};
    private Calendar myCalendar = Calendar.getInstance();
    FirebaseClient firebaseClient;
    private Dialog dialog;
    private Button okBtn,anulBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_appointment);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        (findViewById(R.id.arrow_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Spinner dropdown = (Spinner)findViewById(R.id.doctor_spinner);
        final Spinner dropdown2 = (Spinner)findViewById(R.id.animal_spinner);
        final Spinner dropdown3 = (Spinner)findViewById(R.id.visittype_id);
        TextView button = (TextView)findViewById(R.id.visit);

        final EditText date = (EditText)findViewById(R.id.callendar_id);
        final EditText time = (EditText)findViewById(R.id.hours_id);
        final EditText desc = (EditText)findViewById(R.id.opis_id);

        dialog = new Dialog(VisitAppointment.this);

        firebaseClient = new FirebaseClient(this, DB_URL);


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("doctors");
        mFirebaseInstance2 = FirebaseDatabase.getInstance();
        mFirebaseDatabase2 = mFirebaseInstance.getReference("animals");
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser users = firebaseAuth.getCurrentUser();
        userId = users.getUid();
        rodzajwizyty(dropdown3);

        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String nowy = dataSnapshot.child("name").getValue().toString();
                String id = dataSnapshot.getKey().toString();
                doctors = addElement(doctors, nowy);
                doc = addElement(doc, id);
                func(dropdown, doctors);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        mFirebaseDatabase2.child(userId).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String nowy = dataSnapshot.child("name").getValue().toString();
                String id = userId + "/" + dataSnapshot.getKey().toString();
                animals = addElement(animals, nowy);
                anime = addElement(anime, id);
                func(dropdown2, animals);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wartosc = dropdown2.getSelectedItemPosition();
                if(wartosc==(-1))
                {
                    Toast.makeText(getApplicationContext(), "Brak utworzonych zwierząt!", Toast.LENGTH_LONG).show();
                    newAnimal();

                }
                else if(time.getText().toString().isEmpty() || date.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Wybiez datę i godzinę!", Toast.LENGTH_LONG).show();
                }
                else {
                    int d = dropdown.getSelectedItemPosition();
                    int a = dropdown2.getSelectedItemPosition();
                    int v = dropdown3.getSelectedItemPosition();

                    String idDoc = doc[d];
                    String idAnime = anime[a];
                    String idVisits = visits[v];
                    String pickedtime = time.getText().toString();
                    String pickeddate = date.getText().toString();
                    String opis = desc.getText().toString();
                    String status = "OCZEKUJE";


                    firebaseClient.saveVisit(idDoc, idAnime, pickeddate, pickedtime, idVisits, opis, status);

                    date.setText("");
                    time.setText("");
                    desc.setText("");
                    Toast.makeText(getApplicationContext(), "Pomyślnie umówiono wizytę!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), MyVisitActivity.class));
                }
            }
        });


        final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MMM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.GERMAN);
                date.setText(sdf.format(myCalendar.getTime()));

            }

        };


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(VisitAppointment.this, datePickerListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(VisitAppointment.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Wybierz godzinę");
                mTimePicker.show();

            }
        });







    }


    private void newAnimal() {
        dialog.setContentView(R.layout.dialog_anuluj);

        okBtn = (Button) dialog.findViewById(R.id.okBtn2);
        anulBtn = (Button) dialog.findViewById(R.id.okBtn);
        TextView recText = (TextView) dialog.findViewById(R.id.recText);
        recText.setText("Czy chcesz utworzyć nowe zwierzę?");

        dialog.show();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AnimalActivity.class));

            }
        });
        anulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }





    String[] addElement(String[] org, String added) {
        String[] result = Arrays.copyOf(org, org.length +1);
        result[org.length] = added;
        return result;
    }

    void func(Spinner dropdown, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }

    public void rodzajwizyty(Spinner dropdown) {


        visits = new String[]{"Szczepienie", "Wizyta zwykła", "Leczenie"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, visits);

        dropdown.setAdapter(adapter);
    }

}