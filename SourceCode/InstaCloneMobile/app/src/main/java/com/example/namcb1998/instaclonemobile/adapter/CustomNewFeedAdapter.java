package com.example.namcb1998.instaclonemobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.activity.CommentActivity;
import com.example.namcb1998.instaclonemobile.model.NewFeed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomNewFeedAdapter extends ArrayAdapter<NewFeed> {

    private Context context;
    private int resource;
    private List<NewFeed> arrNewFeed;
    
    public CustomNewFeedAdapter(@NonNull Context context, int resource, ArrayList<NewFeed>arrNewFeed) {
        super(context, resource,arrNewFeed);
        this.context = context;
        this.resource = resource;
        this.arrNewFeed = arrNewFeed;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.new_feed_custom, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.imageAvatar = (ImageView) convertView.findViewById(R.id.image_avatar);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.textview_title);
            viewHolder.imageNewFeed =  (ImageView)convertView.findViewById(R.id.image_newfeed);
            viewHolder.btnLike = convertView.findViewById(R.id.button_like);
            viewHolder.btnDislike = convertView.findViewById(R.id.button_dislike);
            viewHolder.btnComment = convertView.findViewById(R.id.button_comment);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NewFeed newFeed = arrNewFeed.get(position);
        viewHolder.tvName.setText(newFeed.getUserName());
        viewHolder.tvTitle.setText("co ta ra minh on");
        Picasso.get().load("https://i.ytimg.com/vi/ktlQrO2Sifg/maxresdefault.jpg").into(viewHolder.imageAvatar);
        Picasso.get().load("https://i.a4vn.com/2017/10/18/tong-hop-girl-xinh-vong-1-cang-tron-thang-10-2e0f80.jpg").into(viewHolder.imageNewFeed);
        viewHolder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,CommentActivity.class));
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvName, tvTitle;
        ImageView imageAvatar, imageNewFeed;
        ImageView btnLike,btnComment,btnDislike;
    }
}
