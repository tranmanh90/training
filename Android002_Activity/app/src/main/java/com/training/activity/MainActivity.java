package com.training.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    /**
     * Các trạng thái của Activity
     *      1. Running: Activity đang chạy ở trên đỉnh của back stack, tức là Activity đang chạy ở phía trước (foreground).
     *      2. Paused: Một Activity vẫn còn sống nhưng không được focused vào. Pop-up hiện lên trên Activity.
     *      3. Resumed: Khi một Activity quay lại hoạt động. Nó được làm với và chạy lại từ đầu.
     *      4. Stopped: Activity không còn được nhìn thấy thì nó ở trạng thái Stopped.
     *
     * **/

    // Được gọi khi Activity được tạo.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Event");
    }

    // Khi đang Stop chuyển sang reStart.
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: Event");
    }

    // Được gọi khi Activity được nhìn thấy trên mà hình.
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: Event");
    }

    // Được gọi ngay sau onStart(), khi người dùng bắt đầu tường tác với Activity.
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: Event");
    }

    // Được gọi khi activity trước tiếp tực.
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: Event");
    }

    // Được gọi khi một activity khác tiếp tục, và activity này không còn nhìn thấy bởi người dùng.
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: Event");
    }

    // Khi kết thúc activity
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: Event");
    }
}
