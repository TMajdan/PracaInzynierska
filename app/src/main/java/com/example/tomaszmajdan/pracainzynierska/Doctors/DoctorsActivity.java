package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tomaszmajdan.pracainzynierska.Manifest;
import com.example.tomaszmajdan.pracainzynierska.R;

public class DoctorsActivity extends Activity {
    private FragmentManager fmanager;
    ImageView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors3);
        fmanager=getFragmentManager();
        FragmentTransaction ft=fmanager.beginTransaction();
        ft.replace(R.id.fragment,new FirebaseDoctorsHelper());
        ft.commit();



    }





}