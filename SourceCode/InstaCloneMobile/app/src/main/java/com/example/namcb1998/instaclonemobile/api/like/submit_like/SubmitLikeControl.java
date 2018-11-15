package com.example.namcb1998.instaclonemobile.api.like.submit_like;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.Like;
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

public class SubmitLikeControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "Like";
    private String urlUnlike = Config.BASE_URL + "Like/unlike";

    public SubmitLikeControl(Activity activity) {
        super(activity);
    }

    public void submitLike(final int idUserOwner, final int idPost, final SubmitLikeListenner submitLikeListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user_owner", String.valueOf(idUserOwner));
                bodyMap.put("id_post", String.valueOf(idPost));
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitLikeControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitLikeControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final Like like = getLikeFromStringResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitLikeListenner.onSuccess(like);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitLikeListenner.onFail(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            submitLikeListenner.onFail("Like failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    public void unLike(final int idUserOwner, final int idPost, final UnlikeListenner unlikeListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user_owner", String.valueOf(idUserOwner));
                bodyMap.put("id_post", String.valueOf(idPost));
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitLikeControl.this.urlUnlike)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitLikeControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                unlikeListenner.onSuccess();
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                unlikeListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            unlikeListenner.onFailed("Unlike failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private Like getLikeFromStringResult(String result) throws JSONException {
        Like like = new Like();
        JSONObject jsonObject = new JSONObject(result);
        like.setIdPost(jsonObject.getInt("id_post"));
        like.setId(jsonObject.getInt("id"));
        like.setIdUserOwner(jsonObject.getInt("id_owner"));
        like.setCreate_at(jsonObject.getString("created_at"));
        return like;
    }
}
