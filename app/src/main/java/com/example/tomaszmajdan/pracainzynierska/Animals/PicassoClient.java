package com.example.tomaszmajdan.pracainzynierska.Animals;

/**
 * Created by tomas on 09.12.2017.
 */

import android.content.Context;
import android.widget.ImageView;

import com.example.tomaszmajdan.pracainzynierska.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 5/26/2017.
 */

public class PicassoClient {

    public  static  void downloadimg(Context c, String url, ImageView img)
    {
        if (url!=null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.ic_animals).into(img);

        }else
        {
            Picasso.with(c).load(R.drawable.ic_animals).into(img);
        }
    }


}