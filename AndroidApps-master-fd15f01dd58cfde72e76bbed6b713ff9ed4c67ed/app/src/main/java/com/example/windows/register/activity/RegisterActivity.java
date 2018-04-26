package com.example.windows.register.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.windows.register.R;
import com.example.windows.register.controller.UserController;
import com.example.windows.register.model.OwnCallback;
import com.example.windows.register.utils.ValidationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.edNama)
    EditText mTextName;

    @BindView(R.id.edusername)
    EditText mTextUserName;

    @BindView(R.id.edAge)
    EditText mTextAge;

    @BindView(R.id.edp)
    EditText mTextPassword;

    @BindView(R.id.button_Regiser)
    Button mButtonRegister;

    @BindView(R.id.toolbar_default)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private boolean fieldsValidation() {
        return !ValidationUtils.isEmpty(mTextName) &&
                !ValidationUtils.isEmpty(mTextUserName) &&
                !ValidationUtils.isEmpty(mTextAge) &&
                !ValidationUtils.isEmpty(mTextPassword);
    }

    private void registerUser() {
        String name = mTextName.getText().toString().trim();
        String username = mTextUserName.getText().toString().trim();
        String age = mTextAge.getText().toString().trim();
        String password = mTextPassword.getText().toString().trim();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Please Wait");
        dialog.setMessage("Creating User...");
        dialog.setCancelable(false);
        dialog.show();

        UserController.registrasi(name, username, age, password, new OwnCallback() {
            @Override
            public void onSuccess(String message) {
                resetField();
                dialog.dismiss();
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorCode, String message) {
                dialog.dismiss();
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void resetField() {
        mTextName.setText("");
        mTextUserName.setText("");
        mTextAge.setText("");
        mTextPassword.setText("");
    }

    @OnClick(R.id.button_Regiser)
    void onButtonRegisterClick() {
        if (fieldsValidation()) {
            registerUser();
        } else {
            Toast.makeText(RegisterActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        }
    }
}