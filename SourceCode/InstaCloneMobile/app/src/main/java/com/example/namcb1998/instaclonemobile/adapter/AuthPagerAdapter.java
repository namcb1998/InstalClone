package com.example.namcb1998.instaclonemobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.namcb1998.instaclonemobile.fragment.CameraFragment;
import com.example.namcb1998.instaclonemobile.fragment.LoginFragment;
import com.example.namcb1998.instaclonemobile.fragment.RegisterFragment;

/**
 * Created by User_Pro on 10/20/2018.
 */

public class AuthPagerAdapter extends FragmentPagerAdapter {
    private ViewPager mViewPager;
    public AuthPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                LoginFragment loginFragment= new LoginFragment();
                return loginFragment;
            case 1:
                RegisterFragment registerFragment = new RegisterFragment();
                registerFragment.setViewPager(mViewPager);
                return registerFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
        }
        return null;
    }

    public void setAdapter(ViewPager mViewPager){
        this.mViewPager = mViewPager;
    }
}
