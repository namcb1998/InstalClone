package com.example.namcb1998.instaclonemobile.api.like.submit_like;

import com.example.namcb1998.instaclonemobile.model.Like;

public interface SubmitLikeListenner {
    void onSuccess(Like like);

    void onFail(String message);
}
