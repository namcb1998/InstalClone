package com.example.namcb1998.instaclonemobile.api.follow.submit_follow;

import com.example.namcb1998.instaclonemobile.model.Follow;

public interface SubmitFollowListenner {
    void onSuccess(Follow follow);

    void onFail(String message);
}
