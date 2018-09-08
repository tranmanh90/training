package com.android.mvp;

import android.util.Log;
import android.widget.Toast;

import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.view.ILogin;
import com.android.mvp.view.LoginActivity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest implements ILogin {
    
    private static final String TAG = "ExampleUnitTest";

    private LoginPresenter mLoginPresenter;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCheckLogin(){
        String testId = "1";
        String testPw = "1";
        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.checkLogin(testId,testPw);
    }

    @Override
    public void loginSuccesed() {
        Log.i(TAG, "loginSuccesed: ");
    }

    @Override
    public void loginFailed() {
        Log.i(TAG, "loginFailed: ");
    }
}