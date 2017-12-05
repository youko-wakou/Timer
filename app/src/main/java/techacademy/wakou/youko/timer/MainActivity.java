package techacademy.wakou.youko.timer;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer mTimer;
    TextView mTimerText;

    // タイマー用の時間のための変数
    double mTimerSec = 0.0;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimerText = (TextView) findViewById(R.id.timer);

        // タイマーの作成
        mTimer = new Timer();
        // タイマーの始動
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mTimerSec += 0.1;

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTimerText.setText(String.format("%.1f", mTimerSec));
                    }
                });
            }
        }, 100, 100);    // 最初に始動させるまで 100ミリ秒、ループの間隔を 100ミリ秒 に設定
    }
}