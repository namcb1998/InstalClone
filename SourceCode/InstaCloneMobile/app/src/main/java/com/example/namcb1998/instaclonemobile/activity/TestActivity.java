package com.example.namcb1998.instaclonemobile.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.api.auth.get_user.GetUserControl;
import com.example.namcb1998.instaclonemobile.api.auth.get_user.GetUserListenner;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInControl;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInListenner;
import com.example.namcb1998.instaclonemobile.api.auth.signup.SignUpControl;
import com.example.namcb1998.instaclonemobile.api.auth.signup.SignUpListenner;
import com.example.namcb1998.instaclonemobile.api.auth.update_user.UpdateUserControl;
import com.example.namcb1998.instaclonemobile.api.auth.update_user.UpdateUserListenner;
import com.example.namcb1998.instaclonemobile.api.comment.submit_comment.SubmitCommentControl;
import com.example.namcb1998.instaclonemobile.api.comment.submit_comment.SubmitCommentListenner;
import com.example.namcb1998.instaclonemobile.api.follow.submit_follow.SubmitFollowControl;
import com.example.namcb1998.instaclonemobile.api.follow.submit_follow.SubmitFollowListenner;
import com.example.namcb1998.instaclonemobile.api.follow.submit_follow.UnfollowListenner;
import com.example.namcb1998.instaclonemobile.api.like.submit_like.SubmitLikeControl;
import com.example.namcb1998.instaclonemobile.api.like.submit_like.SubmitLikeListenner;
import com.example.namcb1998.instaclonemobile.api.like.submit_like.UnlikeListenner;
import com.example.namcb1998.instaclonemobile.api.post.get_post.GetPostControl;
import com.example.namcb1998.instaclonemobile.api.post.get_post.GetPostListenner;
import com.example.namcb1998.instaclonemobile.api.post.submit_post.SubmitPostControl;
import com.example.namcb1998.instaclonemobile.api.post.submit_post.SubmitPostListenner;
import com.example.namcb1998.instaclonemobile.model.Comment;
import com.example.namcb1998.instaclonemobile.model.Follow;
import com.example.namcb1998.instaclonemobile.model.Like;
import com.example.namcb1998.instaclonemobile.model.Post;
import com.example.namcb1998.instaclonemobile.model.User;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //TODO đăng kí truyền vào username và password

        /*SignUpControl signUpControl = new SignUpControl(this);
        signUpControl.signUp("namcb22", "mjjaa", new SignUpListenner() {
            @Override
            public void onSuccessSignUp(User user) {
                System.out.println(user);
            }

            @Override
            public void onFailedSignUp(String message) {
                System.out.println(message);
            }
        });*/


        //TODO đăng nhập truyền vào username và password
        /*SignInControl signInControl = new SignInControl(this);
        signInControl.signIn("namcb", "mjj", new SignInListenner() {
            @Override
            public void onSuccsess(User user) {
                System.out.println("login succes: " + user);
            }

            @Override
            public void onFailSingIn(String message) {
                System.out.println(message);
            }
        });*/


        //TODO update user, tham số nào ko cần update thì truyền vào null;
        /*Rect rect = new Rect(0, 0, 100, 100);
        Bitmap image = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        int color = Color.RED;
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rect, paint);

        UpdateUserControl updateUserControl = new UpdateUserControl(this);
        updateUserControl.updateUser(1, "updatedisplayname", image, "namcb@gamil.com", null, null, null, new UpdateUserListenner() {
            @Override
            public void onUpdateSuccess(User user) {
                System.out.println(user);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/


        //TODO đăng bài truyền vào ảnh dạng Bitmap
        /*Rect rect = new Rect(0, 0, 100, 100);
        Bitmap image = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        int color = Color.RED;
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rect, paint);


        SubmitPostControl submitPostControl = new SubmitPostControl(this);
        submitPostControl.submitPost(2, "title2", image, Post.PRIVACY_PUBLIC, new SubmitPostListenner() {
            @Override
            public void onSuccess(Post post) {

            }

            @Override
            public void onFailed(String message) {

            }
        });*/


        //TODO lấy list newsfeed select * from post
        /*GetPostControl getPostControl = new GetPostControl(this);
        getPostControl.getAllPost(new GetPostListenner() {
            @Override
            public void onSuccessGetAllPostByUser(List<Post> posts) {
                System.out.println(posts);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/


        //TODO lấy list newsfeed theo user ID (tường);
        /*getPostControl.getAllPostByUserID(1, new GetPostListenner() {
            @Override
            public void onSuccessGetAllPostByUser(List<Post> posts) {
                System.out.println(posts);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/


        //TODO Comment bài viết
       /* SubmitCommentControl submitCommentControl = new SubmitCommentControl(this);
        submitCommentControl.submitComment(1, 1, "aaaa", new SubmitCommentListenner() {
            @Override
            public void onSuccess(Comment comment) {
                System.out.println(comment);
            }

            @Override
            public void onFail(String message) {
                System.out.println(message);
            }
        });*/


        //TODO Follow user
        /*SubmitFollowControl submitFollowControl = new SubmitFollowControl(this);
        submitFollowControl.submitFollow(1, 2, new SubmitFollowListenner() {
            @Override
            public void onSuccess(Follow follow) {
                System.out.println(follow);
            }

            @Override
            public void onFail(String message) {
                System.out.println(message);
            }
        });

        //TODO Unfollow user
        submitFollowControl.unFollow(1, 2, new UnfollowListenner() {
            @Override
            public void onSuccess() {
                System.out.println("success");
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/


        //TODO Like bài viết
        /*SubmitLikeControl submitLikeControl = new SubmitLikeControl(this);
        submitLikeControl.submitLike(1, 1, new SubmitLikeListenner() {
            @Override
            public void onSuccess(Like like) {
                System.out.println(like);
            }

            @Override
            public void onFail(String message) {
                System.out.println(message);
            }
        });*/

        //TODO Unlike bài viết
       /* SubmitLikeControl submitLikeControl = new SubmitLikeControl(this);
        submitLikeControl.unLike(1, 1, new UnlikeListenner() {
            @Override
            public void onSuccess() {
                System.out.println("success");
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/


        //TODO get list user, có thể truyền vào nhiều id
        /*GetUserControl getUserControl = new GetUserControl(this);
        getUserControl.getUsersByListId(new GetUserListenner() {
            @Override
            public void onSuccess(List<User> users) {
                System.out.println(users);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        }, 1, 2);*/

    }
}
