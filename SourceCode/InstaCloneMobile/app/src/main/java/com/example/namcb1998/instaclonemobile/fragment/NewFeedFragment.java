package com.example.namcb1998.instaclonemobile.fragment;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.activity.PostActivity;
import com.example.namcb1998.instaclonemobile.adapter.CustomNewFeedAdapter;
import com.example.namcb1998.instaclonemobile.model.NewFeed;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class NewFeedFragment extends Fragment {
    private ListView lvNewfeed;
    private ArrayList<NewFeed> arrNewFeed;
    private Context context = this.getContext();
    private String uri;
    private Bundle bundle;
    View view;
    private CustomNewFeedAdapter adapter;
    private int test = 0;
    private String status;
    private ImageView camera,post;
    Uri imageUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_feed, container, false);
        view.setId(R.id.fragment_newfeed);
        this.lvNewfeed = view.findViewById(R.id.listview_newfeed);
        this.arrNewFeed = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            NewFeed obj = new NewFeed(status, "abc", "abc");
            arrNewFeed.add(obj);
        }
        CustomNewFeedAdapter adapter = new CustomNewFeedAdapter(view.getContext(), R.layout.fragment_new_feed, arrNewFeed);
        lvNewfeed.setAdapter(adapter);
        initLayout();
        return view;
    }

    private void initLayout(){
        this.camera = view.findViewById(R.id.camera);
        this.post = view.findViewById(R.id.post);
        this.camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }
        });
        this.post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PostActivity.class);
                startActivity(intent);
            }
        });

    }
    public void setStatus(String status){
        this.status = status;
    }

    public void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        imageUri =  getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        getActivity().startActivityForResult(intent, 100);
    }

    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type){
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "MyCameraApp");
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = imageUri;
                    getActivity().getContentResolver().notifyChange(selectedImage, null);
                    ContentResolver cr = getActivity().getContentResolver();
                    Bitmap bitmap;
                    try {
                        bitmap = android.provider.MediaStore.Images.Media
                                .getBitmap(cr, selectedImage);
                        Toast.makeText(getActivity(), selectedImage.toString(),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Failed to load", Toast.LENGTH_SHORT)
                                .show();
                        Log.e("Camera", e.toString());
                    }
                    Intent intent = new Intent(view.getContext(), PostActivity.class);
                    startActivity(intent);
                }
        }
    }
}
