package com.example.namcb1998.instaclonemobile.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.namcb1998.instaclonemobile.R;
import com.example.namcb1998.instaclonemobile.activity.NewFeedActivity;



public class LoginFragment extends Fragment {
    private EditText edt_email;
    private EditText edt_password;
    private Button loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edt_email = view.findViewById(R.id.edt_email);
        edt_password =view.findViewById(R.id.edt_password);
        loginButton = view.findViewById(R.id.button_login);
        initControl();
        initHandle();
        return view;
    }

    public void initControl(){

    }

    public void initHandle(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                Intent intent = new Intent(getActivity(), NewFeedActivity.class);
                startActivity(intent);
            }
        });
    }
}
