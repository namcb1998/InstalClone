package com.example.namcb1998.instaclonemobile.api.auth.update_user;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Base64;

import com.example.namcb1998.instaclonemobile.api.Config;
import com.example.namcb1998.instaclonemobile.api.MainControl;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInControl;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInListenner;
import com.example.namcb1998.instaclonemobile.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateUserControl extends MainControl {
    private OkHttpClient client = new OkHttpClient();
    private String url = Config.BASE_URL + "User/updateUser";

    public UpdateUserControl(Activity activity) {
        super(activity);
    }


    public void updateUser(final int idUser, final String display_name, final Bitmap avatar, final String email, final Integer gender, final Long birthDay, final String password, final UpdateUserListenner updateUserListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("id", String.valueOf(idUser));
                if (display_name != null) {
                    bodyMap.put("display_name", display_name);
                }
                if (email != null) {
                    bodyMap.put("email", email);
                }
                if (gender != null) {
                    bodyMap.put("gender", String.valueOf(gender));
                }
                if (birthDay != null) {
                    bodyMap.put("birthDay", String.valueOf(birthDay));
                }
                if (password != null) {
                    bodyMap.put("password", password);
                }
                if (avatar != null) {
                    bodyMap.put("encode_string", getStringBase64Image(avatar));
                }

                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(bodyMap);

                RequestBody body = RequestBody.create(JSON, jsonString);
                Request request = new Request.Builder()
                        .url(UpdateUserControl.this.url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = UpdateUserControl.this.client.newCall(request).execute();
                    String result = response.body().string();
                    if (response.code() == 201) {
                        final User user = UpdateUserControl.this.getUserFromResult(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateUserListenner.onUpdateSuccess(user);
                            }
                        });
                    } else {
                        final String message = result;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateUserListenner.onFailed(message);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateUserListenner.onFailed("Update failed, check your internet connection");
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

    private String getStringBase64Image(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }
}
