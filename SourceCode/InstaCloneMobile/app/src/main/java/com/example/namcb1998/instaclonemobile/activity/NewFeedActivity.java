package com.example.namcb1998.instaclonemobile.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.adapter.NewFeedPagerAdapter;
import com.example.namcb1998.instaclonemobile.model.NewFeed;

import java.io.Serializable;

public class NewFeedActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private NewFeedPagerAdapter mNewFeedPagerAdapter;
    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mNewFeedPagerAdapter = new NewFeedPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.newfeed_view_pager);
        mViewPager.setAdapter(mNewFeedPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }
}

