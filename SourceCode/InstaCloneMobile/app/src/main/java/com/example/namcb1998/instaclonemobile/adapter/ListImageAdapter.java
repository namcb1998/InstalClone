package com.example.namcb1998.instaclonemobile.adapter;

import android.content.Context;
import android.media.Image;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namcb1998.instaclonemobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User_Pro on 10/30/2018.
 */

public class ListImageAdapter extends BaseAdapter {
    private ArrayList<String> allImageString;
    private Context context;
    private LayoutInflater inflater;

    public ListImageAdapter(Context context, ArrayList<String> allContacts) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.allImageString = allContacts;
    }
    @Override
    public int getCount() {
        return allImageString.size();
    }
    @Override
    public Object getItem(int position) {
        return allImageString.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ContactHolder holder;
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_image_inflater, parent, false);
            holder = new ContactHolder();
            assert view != null;
            holder.imageView =  view.findViewById(R.id.ivImageInflator);
            view.setTag(holder);
        } else {
            holder = (ContactHolder) view.getTag();
        }
        Picasso.get().load("https://i.ytimg.com/vi/ktlQrO2Sifg/maxresdefault.jpg").into(holder.imageView);
        return view;
    }

    public class ContactHolder{
        ImageView imageView;
    }
}
