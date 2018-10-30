package com.example.namcb1998.instaclonemobile.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.adapter.AuthPagerAdapter;
import com.example.namcb1998.instaclonemobile.fragment.LoginFragment;
import com.example.namcb1998.instaclonemobile.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    private AuthPagerAdapter mAuthAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mAuthAdapter = new AuthPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mAuthAdapter);
        mViewPager.setCurrentItem(0);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mAuthAdapter.setAdapter(mViewPager);
    }

}

