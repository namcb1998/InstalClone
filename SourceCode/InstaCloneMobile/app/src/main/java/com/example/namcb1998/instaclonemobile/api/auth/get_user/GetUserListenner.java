package com.example.namcb1998.instaclonemobile.api.auth.get_user;

import com.example.namcb1998.instaclonemobile.model.User;

import java.util.List;

public interface GetUserListenner {
    void onSuccess(List<User> users);

    void onFailed(String message);
}
