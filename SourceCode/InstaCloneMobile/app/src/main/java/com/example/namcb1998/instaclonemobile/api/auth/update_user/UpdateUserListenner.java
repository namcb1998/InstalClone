package com.example.namcb1998.instaclonemobile.api.auth.update_user;

import com.example.namcb1998.instaclonemobile.model.User;

public interface UpdateUserListenner {
    void onUpdateSuccess(User user);

    void onFailed(String message);
}
