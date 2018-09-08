package com.android.mvp.presenter;

import com.android.mvp.model.LoginModel;
import com.android.mvp.view.ILogin;

/**
 * Created by Tran Manh on 9/7/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class LoginPresenter implements ILoginPresenter {

    private ILogin mILogin;
    private LoginModel mLoginModel;

    public LoginPresenter(ILogin login) {
        this.mILogin = login;
        this.mLoginModel = new LoginModel();
    }

    // Gọi tới model để lấy dữ liệu
    @Override
    public void checkLogin(String id, String pw) {

        mLoginModel.setId("manhtran");
        mLoginModel.setPw("1");

        if (id.equals(mLoginModel.getId()) && pw.equals(mLoginModel.getPw())) {
            // Đăng nhập thành công
            mILogin.loginSuccesed();
        } else {
            // Đăng nhập thất bại
            mILogin.loginFailed();
        }
    }
}
