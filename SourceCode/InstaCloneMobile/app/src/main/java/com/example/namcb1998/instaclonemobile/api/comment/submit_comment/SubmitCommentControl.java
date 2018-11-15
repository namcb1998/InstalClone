package com.example.namcb1998.instaclonemobile.api.comment.submit_comment;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.Comment;
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

public class SubmitCommentControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "Comment";

    public SubmitCommentControl(Activity activity) {
        super(activity);

    }

    public void submitComment(final int idUserOwner, final int idPost, final String message, final SubmitCommentListenner submitCommentListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id_user_owner", String.valueOf(idUserOwner));
                bodyMap.put("id_post", String.valueOf(idPost));
                bodyMap.put("message", message);
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SubmitCommentControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SubmitCommentControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final Comment comment = getCommentFromStringResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitCommentListenner.onSuccess(comment);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                submitCommentListenner.onFail(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            submitCommentListenner.onFail("Comment failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private Comment getCommentFromStringResult(String result) throws JSONException {
        Comment comment = new Comment();
        JSONObject jsonObject = new JSONObject(result);
        comment.setIdPost(jsonObject.getInt("id_post"));
        comment.setId(jsonObject.getInt("id"));
        comment.setIdUserOwner(jsonObject.getInt("id_owner"));
        comment.setCreate_at(jsonObject.getString("created_at"));
        return comment;
    }
}
