package com.example.namcb1998.instaclonemobile.api.post.submit_post;

import com.example.namcb1998.instaclonemobile.model.Post;

public interface SubmitPostListenner {
    void onSuccess(Post post);

    void onFailed(String message);
}
