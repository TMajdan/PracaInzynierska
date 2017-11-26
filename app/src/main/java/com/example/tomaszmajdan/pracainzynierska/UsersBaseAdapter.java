package com.example.tomaszmajdan.pracainzynierska;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tomaszmajdan.pracainzynierska.Visit.Visits;

import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;

/**
 * Created by tomas on 26.11.2017.
 */

public class UsersBaseAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<UserData> userData;


    public UsersBaseAdapter(Context context, ArrayList<UserData> userData) {
        this.c = context;
        this.userData = userData;
    }




    @Override
    public int getCount() {
        return userData.size();
    }
    @Override
    public Object getItem(int position) {
        return userData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }




    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_edit_profile,parent,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.textname_id);
        TextView surnameTxt= (TextView) convertView.findViewById(R.id.textsurname_id);
        TextView cityTxt= (TextView) convertView.findViewById(R.id.textcity_id);
        TextView adresTxt= (TextView) convertView.findViewById(R.id.textcity_id);
        TextView phoneTxt= (TextView) convertView.findViewById(R.id.textphone_id);

        final UserData u= (UserData) this.getItem(position);
        nameTxt.setText(u.getName());
        surnameTxt.setText(u.getSurname());
        cityTxt.setText(u.getCity());
        adresTxt.setText(u.getAdres());
        phoneTxt.setText(u.getPhone());

        return convertView;
    }

}
