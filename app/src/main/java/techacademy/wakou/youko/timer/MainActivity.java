package techacademy.wakou.youko.timer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer mTimer;
    TextView mTimerText;
    double mTimerSec = 0.0;

    Handler mHandler = new Handler();

    Button mStartButton;
    Button mPauseButton;
    Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimerText = (TextView) findViewById(R.id.timer);
        mStartButton = (Button) findViewById(R.id.start_button);
        mPauseButton = (Button) findViewById(R.id.pause_button);
        mResetButton = (Button) findViewById(R.id.reset_button);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimer = new Timer();
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
                }, 100, 100);
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimer.cancel();
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimerSec = 0.0;
                mTimerText.setText(String.format("%.1f", mTimerSec));
            }
        });
    }
}