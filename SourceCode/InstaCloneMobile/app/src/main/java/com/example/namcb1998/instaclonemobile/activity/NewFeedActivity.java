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

        Toast.makeText(this, "OH LA LA", Toast.LENGTH_SHORT).show();
        Button btnPost = findViewById(R.id.btn_post);

        Intent intent = getIntent();
        String status = intent.getStringExtra("status");
        String image = intent.getStringExtra("image");
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewFeedActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_1: {
                String messageReturn = data.getStringExtra("message_return");
                Toast.makeText(this, "OH LA LA" + messageReturn, Toast.LENGTH_SHORT).show();
            }
        }
    }

}

