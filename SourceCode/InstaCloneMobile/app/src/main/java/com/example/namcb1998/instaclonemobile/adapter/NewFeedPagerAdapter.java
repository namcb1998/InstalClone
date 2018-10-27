package com.example.namcb1998.instaclonemobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.namcb1998.instaclonemobile.fragment.CameraFragment;
import com.example.namcb1998.instaclonemobile.fragment.LoginFragment;
import com.example.namcb1998.instaclonemobile.fragment.NewFeedFragment;
import com.example.namcb1998.instaclonemobile.fragment.UserFragment;

/**
 * Created by User_Pro on 10/20/2018.
 */

public class NewFeedPagerAdapter extends FragmentPagerAdapter{
    public NewFeedPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                NewFeedFragment newFeedFragment= new NewFeedFragment();
                newFeedFragment.setStatus("chan om");
                return newFeedFragment;
            case 1:
                CameraFragment cameraFragment = new CameraFragment();
                return cameraFragment;
            case 2:
                UserFragment userFragment = new UserFragment();
                return userFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "New Feed";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
