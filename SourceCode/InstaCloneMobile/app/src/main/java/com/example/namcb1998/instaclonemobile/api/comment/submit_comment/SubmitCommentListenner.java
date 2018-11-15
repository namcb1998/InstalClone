package com.example.namcb1998.instaclonemobile.api.comment.submit_comment;

import com.example.namcb1998.instaclonemobile.model.Comment;

public interface SubmitCommentListenner {
    void onSuccess(Comment comment);

    void onFail(String message);
}
