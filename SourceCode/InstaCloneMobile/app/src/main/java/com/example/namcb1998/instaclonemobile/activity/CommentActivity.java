package com.example.namcb1998.instaclonemobile.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.adapter.ListCommentAdapter;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {
    private ImageView avatar;
    private TextView userName,userStatus,send;
    private ListView listView;
    private EditText editTextComment;
    private ArrayList<String> allCommentString = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initLayout();
        initControl();
        initAdapter();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void initLayout(){
        avatar   = findViewById(R.id.image_avatar);
        userName = findViewById(R.id.tvName);
        userStatus  = findViewById(R.id.textview_status);
        send        = findViewById(R.id.textView_send);
        editTextComment    = findViewById(R.id.editText_comment);
        listView           = findViewById(R.id.list_comment);
    }

    private void initControl(){
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void initAdapter(){
        for(int i = 0 ; i < 5 ; i++){
            allCommentString.add("tao la thang mat lozz ten hien");
        }
        ListCommentAdapter adapter = new ListCommentAdapter(this.getApplicationContext(),allCommentString);
        listView.setAdapter(adapter);
        listView.setDivider(null);
    }
}
