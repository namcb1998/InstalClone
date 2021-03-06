package com.example.namcb1998.instaclonemobile.api.auth.signup;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.User;
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

public class SignUpControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "User";

    public SignUpControl(Activity activity) {
        super(activity);
    }


    public void signUp(final String username, final String password, final SignUpListenner signUpListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("username", username);
                bodyMap.put("password", password);
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(SignUpControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = SignUpControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final User user = SignUpControl.this.getUserFromResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                signUpListenner.onSuccessSignUp(user);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (message.contains("Duplicate entry")) {
                                    signUpListenner.onFailedSignUp("Account " + username + " is already exist");
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            signUpListenner.onFailedSignUp("Signup failed, check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private User getUserFromResult(String result) throws JSONException {
        JSONObject jsonObject = null;
        User user = new User();
        jsonObject = new JSONObject(result);
        int id = jsonObject.getInt("id");
        int role = jsonObject.getInt("role");
        int gender = jsonObject.getInt("gender");
        String username = jsonObject.getString("id");
        String displayName = jsonObject.getString("display_name");
        String email = jsonObject.getString("email");
        if (email.equals("null")) {
            email = null;
        }
        String link_avatar = jsonObject.getString("link_avatar");
        if (!link_avatar.contains("http")) {
            link_avatar = Config.BASE_URL + "avatar/" + link_avatar;
        }
        long time = jsonObject.getLong("birthday");
        user.setBirthday(time);
        user.setDisplay_name(displayName);
        user.setEmail(email);
        user.setGender(gender);
        user.setUsername(username);
        user.setRole(role);
        user.setId(id);
        user.setLink_avatar(link_avatar);

        return user;
    }
}
