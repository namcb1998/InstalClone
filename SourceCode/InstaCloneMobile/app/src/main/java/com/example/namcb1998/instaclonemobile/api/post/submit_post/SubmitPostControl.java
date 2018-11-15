package com.example.namcb1998.instaclonemobile.api.post.submit_post;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Base64;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.Post;
import com.example.namcb1998.instaclonemobile.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SubmitPostControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "Post";

    public SubmitPostControl(Activity activity) {
        super(activity);
    }

    public void submitPost(final int idUser, final String titlePost, final Bitmap bitmap, final int privacy, final SubmitPostListenner submitPostListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user", String.valueOf(idUser));
                bodyMap.put("title", titlePost);
                bodyMap.put("encode_string", getStringBase64Image(bitmap));
                bodyMap.put("privacy", String.valueOf(privacy));
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitPostControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitPostControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final Post post = new Post();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitPostListenner.onSuccess(post);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitPostListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            submitPostListenner.onFailed("Post failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private String getStringBase64Image(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

}
