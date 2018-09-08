package com.android.mvp.model;

/**
 * Created by Tran Manh on 9/7/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class LoginModel {
    private String id;
    private String pw;

    public LoginModel() {
    }

    public LoginModel(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginModel{");
        sb.append("id='").append(id).append('\'');
        sb.append(", pw='").append(pw).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
