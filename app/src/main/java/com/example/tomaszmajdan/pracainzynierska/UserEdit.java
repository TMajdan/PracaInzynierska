package com.example.tomaszmajdan.pracainzynierska;



import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserEdit extends AppCompatActivity  implements View.OnClickListener {

        //firebase auth object
        private FirebaseAuth firebaseAuth;

        //view objects
        private Button buttonSa;

        private DatabaseReference databaseReference;

        private EditText editTextName, editTextSurname, editTextPhone,
                editTextAddress, editTextZip, editTextPesel, editTextCity;
        private Button buttonSave;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_info);

            //initializing firebase authentication object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the user is not logged in
            //that means current user will return null
            if(firebaseAuth.getCurrentUser() == null){
                //closing this activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
            }


            databaseReference = FirebaseDatabase.getInstance().getReference();
            editTextName = (EditText) findViewById(R.id.editTextName);
            editTextSurname = (EditText) findViewById(R.id.editTextSurname);
            editTextPhone = (EditText) findViewById(R.id.editTextPhone);
            editTextAddress = (EditText) findViewById(R.id.editTextAddress);
            editTextZip = (EditText) findViewById(R.id.editTextZip);
            editTextPesel = (EditText) findViewById(R.id.editTextPesel);
            editTextCity= (EditText) findViewById(R.id.editTextCity) ;

            //getting current user
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //initializing views

            buttonSa = (Button) findViewById(R.id.buttonSave);


            //adding listener to button
            buttonSa.setOnClickListener(this);
        }


        private void saveUserInformation()
        {
            String name  = editTextName.getText().toString().trim();
            String surname = editTextSurname.getText().toString().trim();
            String pesel = editTextPesel.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();
            String city = editTextCity.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String zip = editTextZip.getText().toString().trim();

            UserInformation userInformation = new UserInformation(name, surname, pesel, phone, city, address, zip);

            FirebaseUser user = firebaseAuth.getCurrentUser();

            databaseReference.child(user.getUid()).setValue(userInformation);

            Toast.makeText(this, "Informacje zapisane!", Toast.LENGTH_LONG).show();
        }


        private void showUpdateDialog(String Name)
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

            LayoutInflater inflater = getLayoutInflater();

            final View dialogView = inflater.inflate(R.layout.activity_update_dialog, null);

            dialogBuilder.setView(dialogView);

            final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);

            final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);

            AlertDialog alertDialog = dialogBuilder.create();

            alertDialog.show();





        }



        @Override
        public void onClick(View view) {
            //if save is pressed

            if(view == buttonSa){
                saveUserInformation();
                //closing activity
                finish();
                //starting login activity
                startActivity(new Intent(this, MainPage.class));
            }



            
        }


    }
