package com.android.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mvp.R;
import com.android.mvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILogin {

    private EditText mId;
    private EditText mPw;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginPresenter = new LoginPresenter(this);
        mId = findViewById(R.id.edit_text_id);
        mPw = findViewById(R.id.edit_text_pw);

        findViewById(R.id.main_layout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }

    @Override
    public void loginSuccesed() {
        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
    }

    public void onEnterClick(View view) {
        mLoginPresenter.checkLogin(mId.getText().toString(), mPw.getText().toString());
    }


}
