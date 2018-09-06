package com.android.button;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tran Manh on 9/6/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class JMainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button01 = findViewById(R.id.button01);
        final TextView textView01 = findViewById(R.id.textView01);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView01.setVisibility(View.VISIBLE);
            }
        });

    }

    public void onClickButton02(View view) {
        TextView textView02 = findViewById(R.id.textView02);
        textView02.setVisibility(View.VISIBLE);
    }

}
