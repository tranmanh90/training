package com.training.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
* Khởi chạy một Activity bằng một ACtivity khác thông qua phương thức:
* startActivity() => Đưa người dùng tới màn hình tiếp theo.
* startActivityForResult() => Khởi chạy một Activity sau đó nhận kết quả trả về.
*
* */

public class MainActivity extends AppCompatActivity {

    private Button mClickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickButton = findViewById(R.id.button_click);
        mClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
