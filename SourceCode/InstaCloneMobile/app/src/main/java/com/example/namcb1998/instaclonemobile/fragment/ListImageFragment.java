package com.example.namcb1998.instaclonemobile.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.adapter.ListImageAdapter;

import java.util.ArrayList;

public class ListImageFragment extends Fragment {
    View view;
    private ListView listView;
    ArrayList<String> allImageString = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_image, container, false);
        return view;
    }

    private void getAllWidgets(View view) {
        listView = (ListView) view.findViewById(R.id.listFragmentTwo);
    }

    private void setAdapter(View view)
    {
        for (int i = 0; i < 3 ; i++) {
           allImageString.add("abc");
        }
        ListImageAdapter listViewAdapter= new ListImageAdapter(view.getContext(), allImageString);
        listView.setAdapter(listViewAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getAllWidgets(this.view);
        setAdapter(this.view);
    }
}
