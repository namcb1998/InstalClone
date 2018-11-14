package com.example.namcb1998.instaclonemobile.api.auth.signup;

import com.example.namcb1998.instaclonemobile.model.User;

public interface SignUpListenner {
    void onSuccessSignUp(User user);

    void onFailedSignUp(String message);


}
