package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.widget.ListView;

import com.example.tomaszmajdan.pracainzynierska.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MyDoctorsActivity  extends Activity {
    //final static  String DB_URL= "https://pracainzynierska-f1b54.firebaseio.com/visits/" + MainActivity.userID;
    final static  String DB_URL= "https://pracainzynierska-dd3c1.firebaseio.com/doctors";
    ListView listView;

    FirebaseDoctors firebaseClient;

    static Dialog dialog;

    protected Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_visit2);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);



        listView=(ListView)findViewById(R.id.listview);
        firebaseClient= new FirebaseDoctors(this, DB_URL,listView);
        firebaseClient.refreshdataVisits();

        dialog=new Dialog(MyDoctorsActivity.this);





    }


}