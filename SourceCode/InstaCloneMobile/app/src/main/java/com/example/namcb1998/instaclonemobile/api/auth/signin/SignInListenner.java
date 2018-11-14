package com.example.namcb1998.instaclonemobile.api.auth.signin;

import com.example.namcb1998.instaclonemobile.model.User;

public interface SignInListenner {
    void onSuccsess(User user);

    void onFailSingIn(String message);

}
