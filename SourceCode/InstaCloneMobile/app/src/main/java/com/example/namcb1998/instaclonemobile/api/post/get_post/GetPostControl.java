package com.example.namcb1998.instaclonemobile.api.post.get_post;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetPostControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String urlAllPost = Config.BASE_URL + "Post";
    private String urlPostByUser = Config.BASE_URL + "Post/getbyuserid";

    public GetPostControl(Activity activity) {
        super(activity);
    }


    public void getAllPostByUserID(final int idUser, final GetPostListenner getPostListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user", String.valueOf(idUser));
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(GetPostControl.this.urlPostByUser)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = GetPostControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final List<Post> posts = getListPostFromResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getPostListenner.onSuccessGetAllPostByUser(posts);
                            }
                        });
                    } else {
                        JSONObject jsonObject = new JSONObject(result);
                        final String message = jsonObject.getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getPostListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getPostListenner.onFailed("Post failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    public void getAllPost(final GetPostListenner getPostListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(GetPostControl.this.urlAllPost)
                        .build();
                Response response = null;
                try {
                    response = GetPostControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final List<Post> posts = getListPostFromResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getPostListenner.onSuccessGetAllPostByUser(posts);
                            }
                        });
                    } else {
                        JSONObject jsonObject = new JSONObject(result);
                        final String message = jsonObject.getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getPostListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getPostListenner.onFailed("Post failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private List<Post> getListPostFromResult(String result) throws JSONException {
        List<Post> posts = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(result);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Post post = new Post();
            int id = jsonObject.getInt("id");
            int idUser = jsonObject.getInt("id_user");
            String linkImage = Config.BASE_URL + jsonObject.getString("image_link");
            String title = jsonObject.getString("title");
            String create_at = jsonObject.getString("created_at");
            int privacy = jsonObject.getInt("privacy");
            post.setId(id);
            post.setCreated_at(create_at);
            post.setId_user(idUser);
            post.setImage_link(linkImage);
            post.setPrivacy(privacy);
            post.setTitle(title);
            posts.add(post);
        }
        return posts;
    }

    private Post getPostFromResult(String result) throws JSONException {
        Post post = new Post();
        JSONObject jsonObject = new JSONObject(result);
        int id = jsonObject.getInt("id");
        int idUser = jsonObject.getInt("id_user");
        String linkImage = Config.BASE_URL + jsonObject.getString("image_link");
        String title = jsonObject.getString("title");
        String create_at = jsonObject.getString("created_at");
        int privacy = jsonObject.getInt("privacy");
        post.setId(id);
        post.setCreated_at(create_at);
        post.setId_user(idUser);
        post.setImage_link(linkImage);
        post.setPrivacy(privacy);
        post.setTitle(title);
        return post;
    }
}
