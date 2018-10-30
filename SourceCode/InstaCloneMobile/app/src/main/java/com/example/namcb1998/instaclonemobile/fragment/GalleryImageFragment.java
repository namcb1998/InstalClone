package com.example.namcb1998.instaclonemobile.fragment;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.activity.MainActivity;
import com.example.namcb1998.instaclonemobile.adapter.GalleryAdapter;

import java.util.ArrayList;

public class GalleryImageFragment extends Fragment {
    private GridView gridView;
    ArrayList<String> allDrawableImages = new ArrayList<>();
    private TypedArray allImages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery_image, null);
        getAllWidgets(rootView);
        setAdapter(rootView);
        return rootView;
    }

    private void getAllWidgets(View view) {
        gridView = (GridView) view.findViewById(R.id.gridViewFragmentOne);
    }
    private void setAdapter(View view)
    {
        for (int i = 0; i <1 ; i++) {
            allDrawableImages.add("abc");
        }
        GalleryAdapter gridViewAdapter = new GalleryAdapter(view.getContext(), allDrawableImages);
        gridView.setAdapter(gridViewAdapter);
    }
}
