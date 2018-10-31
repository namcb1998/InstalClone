package com.example.namcb1998.instaclonemobile.adapter;

import android.content.Context;
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
 * Created by User_Pro on 10/31/2018.
 */

public class ListCommentAdapter extends BaseAdapter{
    private ArrayList<String> allCommentString;
    private Context context;
    private LayoutInflater inflater;

    public ListCommentAdapter( Context context,ArrayList<String> allCommentString) {
        this.inflater = LayoutInflater.from(context);
        this.allCommentString = allCommentString;
        this.context = context;
    }

    @Override
    public int getCount() {
        return allCommentString.size();
    }

    @Override
    public Object getItem(int i) {
        return allCommentString.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final CommentHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.custom_comment, viewGroup, false);
            holder = new CommentHolder();
            assert view != null;
            holder.imageView =  view.findViewById(R.id.image_avatar);
            holder.name = view.findViewById(R.id.textview_name);
            holder.comment = view.findViewById(R.id.textview_comment);
            view.setTag(holder);
        } else {
            holder = (CommentHolder) view.getTag();
        }
        Picasso.get().load("https://i.ytimg.com/vi/ktlQrO2Sifg/maxresdefault.jpg").into(holder.imageView);
        holder.comment.setText(allCommentString.get(i));
        return view;
    }

    public class CommentHolder{
        ImageView imageView;
        TextView name,comment;
    }
}
