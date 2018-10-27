package com.example.namcb1998.instaclonemobile.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.activity.MainActivity;
import com.example.namcb1998.instaclonemobile.activity.PostActivity;
import com.example.namcb1998.instaclonemobile.adapter.CustomNewFeedAdapter;
import com.example.namcb1998.instaclonemobile.java.FragmentCommunicator;
import com.example.namcb1998.instaclonemobile.model.NewFeed;
import com.squareup.picasso.Picasso;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class NewFeedFragment extends Fragment {
    private ListView lvNewfeed;
    private ArrayList<NewFeed> arrNewFeed = new ArrayList<>();
    ;
    private Context context = this.getContext();
    private String uri;
    private Bundle bundle;
    View view;
    private CustomNewFeedAdapter adapter;
    private int test = 0;
    private String status;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_feed, container, false);
        view.setId(R.id.fragment_newfeed);
        this.lvNewfeed = view.findViewById(R.id.listview_newfeed);
        for (int i = 0; i < 5; i++) {
            NewFeed obj = new NewFeed(status, "abc", "abc");
            arrNewFeed.add(obj);
        }
        CustomNewFeedAdapter adapter = new CustomNewFeedAdapter(view.getContext(), R.layout.fragment_new_feed, arrNewFeed);
        lvNewfeed.setAdapter(adapter);
        return view;
    }


    public void setStatus(String status){
        this.status = status;
    }
}
