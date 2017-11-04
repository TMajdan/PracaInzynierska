package com.example.tomaszmajdan.pracainzynierska.Doctors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tomaszmajdan.pracainzynierska.R;


import java.util.ArrayList;

/**
 *
 */

public class Doctors extends BaseAdapter {

    private Context c;
    private ArrayList<Upcomings> upcomings;


    public Doctors(Context context, ArrayList<Upcomings> upcomings) {
        this.c = context;
        this.upcomings = upcomings;
    }


    @Override
    public int getCount() {
        return upcomings.size();
    }
    @Override
    public Object getItem(int position) {
        return upcomings.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    /*
    @Override
    public UpcomingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.activity_doctors, parent, false);

        UpcomingViewHolder upcomingViewHolder = new UpcomingViewHolder(view);
        return upcomingViewHolder;
    }
*/



    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_doctors,parent,false);
        }
        TextView imieTxt= (TextView) convertView.findViewById(R.id.doctor_name);

        TextView descTxt= (TextView) convertView.findViewById(R.id.doctor_desc);

        TextView roomTxt= (TextView) convertView.findViewById(R.id.nr_room);

        TextView phoneTxt = (TextView) convertView.findViewById(R.id.doctor_phone);

        // TextView rasaTxt = (TextView) convertView.findViewById(R.id.descTxt4);

        //  TextView mascTxt = (TextView) convertView.findViewById(R.id.propellantTxt);

        final Upcomings u= (Upcomings) this.getItem(position);
        imieTxt.setText(u.getName());
        descTxt.setText(u.getDesc());
        roomTxt.setText(u.getRoom());
        phoneTxt.setText(u.getPhone());


        return convertView;
    }

   /*
    @Override
    public void onBindViewHolder(final FirebaseDoctorsHelper holder, int position) {
        final Upcomings upcoming = upcomings.get(position);
        //String fullUrl = "http://vga.ramstertech.com/happyhour/images/" + upcoming.image + ".jpg";
        Glide
                .with(context)
                .load(fullUrl)
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()


        holder.doctorphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent.setData(Uri.parse("tel:" +upcoming.phone.toString())));

            }
        });

        holder.doctorname.setText(upcoming.name.toString());
        holder.doctornamedesc.setText(upcoming.description.toString());
        holder.doctorlocation.setText(upcoming.location.toString());
        holder.shopvalid.setText(upcoming.valid.toString());

        holder.shopmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", upcoming.latitude, upcoming.longitude, "Routing to "+upcoming.name);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if(upcomings != null){
            return upcomings.size();
        }
        return 0;
    }


    //ViewHolder class
    public static class UpcomingViewHolder extends RecyclerView.ViewHolder{

        public CardView cvUpcoming;

        public TextView doctorname;

        public TextView doctornamedesc;

        public TextView doctorlocation;

        public TextView shopvalid;

        public ImageView upcomingimage;

        public ImageView shopmap;

        public ImageView doctorphone;


        public UpcomingViewHolder(View itemView) {
            super(itemView);

            cvUpcoming = (CardView)itemView.findViewById(R.id.cvUpcoming);


            doctorname = (TextView)itemView.findViewById(R.id.Doctor_name);

            doctornamedesc = (TextView)itemView.findViewById(R.id.doctor_desc);

            //doctorlocation = (TextView)itemView.findViewById(R.id.shoplocation);

            shopvalid = (TextView)itemView.findViewById(R.id.shopvalid);

            //upcomingimage=(ImageView)itemView.findViewById(R.id.shopimage);

            shopmap=(ImageView)itemView.findViewById(R.id.shopmap);

            doctorphone = (ImageView)itemView.findViewById(R.id.phonecall);



        }
    }
    */
}