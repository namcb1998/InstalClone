package com.example.namcb1998.instaclonemobile.api.auth.get_user;

import android.app.Activity;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetUserControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "User/getUser";

    public GetUserControl(Activity activity) {
        super(activity);
    }

    public void getUsersByListId(final GetUserListenner getUserListenner, Integer... id) { //chuyen nhieu  id vao
        List<Integer> listIdUser = Arrays.asList(id);
        Gson gson = new GsonBuilder().create();
        final String jsonString = gson.toJson(listIdUser);
        System.out.println(jsonString);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("list_id", jsonString);
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(GetUserControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = GetUserControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final List<User> users = getUserList(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getUserListenner.onSuccess(users);
                            }
                        });
                    } else {
                        final String message = new JSONArray(result).getJSONObject(0).getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getUserListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getUserListenner.onFailed("Check your internet connection");
                        }
                    });
                }
            }
        }).start();
    }

    private List<User> getUserList(String result) throws JSONException {
        List<User> users = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(result);
        for (int i = 0; i < jsonArray.length(); i++) {
            User user = new User();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
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
            users.add(user);
        }
        return users;
    }
}
