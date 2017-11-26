package com.example.tomaszmajdan.pracainzynierska;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.Animals.AnimalActivity;
import com.example.tomaszmajdan.pracainzynierska.Visit.MyVisitActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.tomaszmajdan.pracainzynierska.R.id.add;
import static com.example.tomaszmajdan.pracainzynierska.R.id.address;
import static com.example.tomaszmajdan.pracainzynierska.R.id.adres_id;
import static com.example.tomaszmajdan.pracainzynierska.R.id.city;
import static com.example.tomaszmajdan.pracainzynierska.R.id.city_id;
import static com.example.tomaszmajdan.pracainzynierska.R.id.name;
//import static com.example.tomaszmajdan.pracainzynierska.R.id.pesel;
import static com.example.tomaszmajdan.pracainzynierska.R.id.phone;
import static com.example.tomaszmajdan.pracainzynierska.R.id.phone_id;
import static com.example.tomaszmajdan.pracainzynierska.R.id.surname;
//import static com.example.tomaszmajdan.pracainzynierska.R.id.zip;

public class UserEdit extends Activity {

    private static final String TAG = UserEdit.class.getSimpleName();
    private TextView txtName, txtSurname, txtCity, txtAdres, txtPhone;
    private EditText inputName, inputSurname, inputPesel, inputPhone, inputCity, inputAddress, inputZip;
    private Button btnSave, btnBack;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth firebaseAuth;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        (findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), MainActivity.class));

            }
        });

        btnSave = (Button) findViewById(R.id.btn_save);
        txtName = (TextView) findViewById(R.id.textname_id);
        txtSurname = (TextView) findViewById(R.id.textsurname_id);
        txtCity = (TextView) findViewById(R.id.textcity_id);
        txtAdres = (TextView) findViewById(R.id.textadres_id);
        txtPhone = (TextView) findViewById(R.id.textphone_id);




        inputCity = (EditText) findViewById(city_id);
        inputAddress = (EditText) findViewById(adres_id);
        inputPhone = (EditText) findViewById(phone_id);


        btnSave = (Button) findViewById(R.id.btn_save);

        //FirebaseUser user = firebaseAuth.getCurrentUser();

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        // store app title to 'app_title' node
        //mFirebaseInstance.getReference("app_title").setValue("Realtime Database");




        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });

        // Save / update the user
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String name = inputName.getText().toString();
               // String surname = inputSurname.getText().toString();
                // String pesel = inputPesel.getText().toString();
                String phone = inputPhone.getText().toString();
                String city = inputCity.getText().toString();
                String address = inputAddress.getText().toString();
                // String zip = inputZip.getText().toString();

                // Check for already existed userId
                //    if (TextUtils.isEmpty(userId)) {
                //       createUser(name, surname, pesel, phone, city, address, zip);
                //     } else {
                updateUser(phone, city, address);
                //      }
            }
        });


      //  btnBack.setOnClickListener(new View.OnClickListener() {
     //       @Override
      //      public void onClick(View v) {
      //          // Add your code in here!
     //           finish();
     //           //starting login activity
      //          startActivity(new Intent(v.getContext(), MainActivity.class));
      //      }
     //   });

        // toggleButton();
    }

    // Changing button text
    //  private void toggleButton() {
    //     if (TextUtils.isEmpty(userId)) {
    //         btnSave.setText("Save");
    //     } else {
    //         btnSave.setText("Update");
    //     }
    //  }

    /**
     * Creating new user node under 'users'
     */



    private void createUser (String name, String surname, String pesel, String phone, String address, String city, String zip) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser users = firebaseAuth.getCurrentUser();
        userId = users.getUid();
        User test = new User(name,surname,pesel,phone,address,city,zip);


        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }



        mFirebaseDatabase.child(userId).setValue(test);

        addUserChangeListener();
    }

    /**
     * User data change listener
     */
    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User users = dataSnapshot.getValue(User.class);

                // Check for null
                if (users == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                //  Log.e(TAG, "User data is changed!" + users.name + ", " + users.surname);

                // Display newly updated name and email
            //   txtDetails.setText(users.name + ", " + users.surname + ", " + users.phone
            //            + ", " + users.city + ", " + users.address + ", "
                txtName.setText(users.name);
                txtSurname.setText(users.surname);
                txtAdres.setText(users.address);
                txtCity.setText(users.city);
                txtPhone.setText(users.phone);

            //    );

                // clear edit text
//                inputSurname.setText("");
    //            inputName.setText("");
                // inputZip.setText("");
                inputPhone.setText("");
                // inputPesel.setText("");
                inputAddress.setText("");
                inputCity.setText("");



                //   toggleButton();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    private void updateUser(String phone, String address, String city) {
        // updating the user via child nodes

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser users = firebaseAuth.getCurrentUser();
        userId = users.getUid();
        // User test = new User(name,surname,pesel,phone,address,city,zip);


        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }


        //mFirebaseDatabase.child(userId).setValue(test);
        addUserChangeListener();


        if(phone.length() == 0) {
        }
        else {
            mFirebaseDatabase.child(userId).child("phone").setValue(phone);
        }

        if(address.length() == 0) {
        }
        else {
            mFirebaseDatabase.child(userId).child("address").setValue(address);
        }
        //  if (!TextUtils.isEmpty(city))
        if(city.length() == 0) {
        }
        else {
            mFirebaseDatabase.child(userId).child("city").setValue(city);
        }

    }
}