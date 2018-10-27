package com.example.namcb1998.instaclonemobile.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.namcb1998.instaclonemobile.R;

public class RegisterFragment extends Fragment {
    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_phoneNumber;
    private Button registerButton;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        edt_email = view.findViewById(R.id.edt_email);
        edt_password = view.findViewById(R.id.edt_password);
        edt_phoneNumber = view.findViewById(R.id.edt_phoneNumber);
        registerButton =  view.findViewById(R.id.button_register);
        initHandle();
        return view;
    }

    public void initHandle(){
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                String phone = edt_phoneNumber.getText().toString();
                mViewPager.setCurrentItem(0);
            }
        });
    }

    public  void setViewPager(ViewPager mViewpager){
        this.mViewPager = mViewpager;
    }
}
