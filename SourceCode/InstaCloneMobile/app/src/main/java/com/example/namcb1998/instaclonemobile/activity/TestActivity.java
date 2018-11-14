package com.example.namcb1998.instaclonemobile.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInControl;
import com.example.namcb1998.instaclonemobile.api.auth.signin.SignInListenner;
import com.example.namcb1998.instaclonemobile.api.post.get_post.GetPostControl;
import com.example.namcb1998.instaclonemobile.api.post.get_post.GetPostListenner;
import com.example.namcb1998.instaclonemobile.api.post.submit_post.SubmitPostControl;
import com.example.namcb1998.instaclonemobile.api.post.submit_post.SubmitPostListenner;
import com.example.namcb1998.instaclonemobile.model.Post;
import com.example.namcb1998.instaclonemobile.model.User;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /*SignUpControl signUpControl = new SignUpControl(this);
        signUpControl.signUp("namcb", "mjj", new SignUpListenner() {
            @Override
            public void onSuccessSignUp(User user) {

            }

            @Override
            public void onFailedSignUp(String message) {

            }
        });*/


        /*SignInControl signInControl = new SignInControl(this);
        signInControl.signIn("namcb", "mjj", new SignInListenner() {
            @Override
            public void onSuccsess(User user) {
                System.out.println(user);
            }

            @Override
            public void onFailSingIn(String message) {
                System.out.println(message);
            }
        });*/




       /* Rect rect = new Rect(0, 0, 100, 100);
        Bitmap image = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        int color = Color.RED;
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rect, paint);


        SubmitPostControl submitPostControl = new SubmitPostControl(this);
        submitPostControl.submitPost(1, "title",image , Post.PRIVACY_PUBLIC, new SubmitPostListenner() {
            @Override
            public void onSuccess(Post post) {

            }

            @Override
            public void onFailed(String message) {

            }
        });*/

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
        });
        getPostControl.getAllPostByUserID(1, new GetPostListenner() {
            @Override
            public void onSuccessGetAllPostByUser(List<Post> posts) {
                System.out.println(posts);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });*/
    }
}
