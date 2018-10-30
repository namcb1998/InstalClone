package com.example.namcb1998.instaclonemobile.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.namcb1998.instaclonemobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {
    public ArrayList<String> allItemsResourceID;
    private LayoutInflater inflater;
    Context context;
    public GalleryAdapter(Context context, ArrayList<String> images) {
        inflater = LayoutInflater.from(context);
        this.context = context;
//
        allItemsResourceID = images;
        Log.d("Adapter", "Create Image Adapter " + allItemsResourceID.size());
    }
    public GalleryAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return allItemsResourceID.size();
    }
    @Override
    public Object getItem(int position) {
        return allItemsResourceID.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.image_inflater, parent, false);
            holder = new ViewHolder();
            assert view != null;
            holder.imageView = (ImageView) view.findViewById(R.id.ivImageInflator);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Picasso.get().load("https://i.ytimg.com/vi/ktlQrO2Sifg/maxresdefault.jpg").into(holder.imageView);
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
    }
}
