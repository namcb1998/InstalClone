package com.example.namcb1998.instaclonemobile.api.post.get_post;

import com.example.namcb1998.instaclonemobile.model.Post;

import java.util.List;

public interface GetPostListenner {
    void onSuccessGetAllPostByUser(List<Post> posts);

    void onFailed(String message);

    /*void onGetSinglePost(Post post);*/
}
