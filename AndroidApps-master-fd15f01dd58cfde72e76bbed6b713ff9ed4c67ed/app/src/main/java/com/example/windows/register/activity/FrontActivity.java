package com.example.windows.register.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.windows.register.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrontActivity extends AppCompatActivity {

    @BindView(R.id.textRegister)
    TextView mTextRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.textRegister)
    void onTextRegisterClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
