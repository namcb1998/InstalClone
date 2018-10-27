package com.example.namcb1998.instaclonemobile.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.fragment.NewFeedFragment;
import com.example.namcb1998.instaclonemobile.model.NewFeed;
import com.squareup.picasso.Picasso;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {
    private  ImageView imagePost;
    private  Uri uri;
    private final static int REQUEST_CODE_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ImageView tvAvatar = findViewById(R.id.image_avatar);
        TextView tvName = findViewById(R.id.tvName);
        final EditText edtStatus = findViewById(R.id.edt_status);
        imagePost = findViewById(R.id.image_post);
        Button btnPost = findViewById(R.id.btn_post);
        Button btnImage = findViewById(R.id.btn_image);
        final NewFeedFragment newFeedFragment = new NewFeedFragment();

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = edtStatus.getText().toString();
                Intent intent = new Intent(PostActivity.this, NewFeedActivity.class);
                String uriTostring = "";
                if(uri != null){
                    uriTostring  = uri.toString();
                }
                NewFeed newFeed =  new NewFeed("quang linh","abc","abc");
                intent.putExtra("status",status);
                intent.putExtra("image","abc " + uriTostring);
                intent.putExtra("message", "This message comes from PassingDataSourceActivity's second button");
                setResult(REQUEST_CODE_1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                uri = getImageUri(this.getApplicationContext(), bitmap);
                Picasso.get().load(uri).into(imagePost);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "title", null);
        return Uri.parse(path);
    }

}
