package com.example.namcb1998.instaclonemobile.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.namcb1998.instaclonemobile.R;

public class UserFragment extends Fragment {
    private TabLayout allTabs;
    private Fragment galleryImageFragment;
    private Fragment listImageFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        getAllWidgets(view);
        bindWidgetsWithAnEvent();
        setupTabLayout();
        return view;
    }

    private void getAllWidgets(View view) {
        this.allTabs = view.findViewById (R.id.tabs);
    }

    private void setupTabLayout() {
        this.galleryImageFragment = new GalleryImageFragment();
        this.listImageFragment = new ListImageFragment();
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.grid),true);
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.list));
    }

    private void bindWidgetsWithAnEvent()
    {
        this.allTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(this.galleryImageFragment);
                break;
            case 1 :
                replaceFragment(listImageFragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
