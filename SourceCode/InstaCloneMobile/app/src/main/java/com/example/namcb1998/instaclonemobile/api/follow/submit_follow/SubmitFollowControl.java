package com.example.namcb1998.instaclonemobile.api.follow.submit_follow;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.Follow;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SubmitFollowControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "Follow";
    private String urlUnFollow = Config.BASE_URL + "Follow/unfollow";

    public SubmitFollowControl(Activity activity) {
        super(activity);
    }

    //idUser follow idUserfollow
    public void submitFollow(final int idUser, final int idUserFollow, final SubmitFollowListenner submitFollowListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user", String.valueOf(idUser));
                bodyMap.put("id_user_follow", String.valueOf(idUserFollow)); //idUser follow idUserfollow
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitFollowControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitFollowControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final Follow follow = getFollowFromStringResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitFollowListenner.onSuccess(follow);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitFollowListenner.onFail(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            submitFollowListenner.onFail("Follow failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    //idUser unfollow idUserfollow
    public void unFollow(final int idUser, final int idUserFollow, final UnfollowListenner unfollowListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user", String.valueOf(idUser));
                bodyMap.put("id_user_follow", String.valueOf(idUserFollow)); //idUser unfollow idUserfollow
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitFollowControl.this.urlUnFollow)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitFollowControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                unfollowListenner.onSuccess();
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                unfollowListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            unfollowListenner.onFailed("Unfollow failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }


    private Follow getFollowFromStringResult(String result) throws JSONException {
        Follow follow = new Follow();
        JSONObject jsonObject = new JSONObject(result);
        follow.setIdUserFollow(jsonObject.getInt("id_user_follow"));
        follow.setId(jsonObject.getInt("id"));
        follow.setIdUser(jsonObject.getInt("id_user"));
        return follow;
    }
}
