package com.example.milestoneandriod;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.SystemClock;


public class MainActivity extends AppCompatActivity {
    private Handler mHandler;

    private Runnable myRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Just create simple XML layout with i.e a single ImageView or a custom layout
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        myRunnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

    }



    @Override
    public void onBackPressed() {
// Remove callback on back press
        if (mHandler != null && myRunnable != null) {
            mHandler.removeCallbacks(myRunnable);
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
// Remove callback on pause
        if (mHandler != null && myRunnable != null) {
            mHandler.removeCallbacks(myRunnable);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
// Attach and start callback with delay on resume
        if (mHandler != null && myRunnable != null) {
            mHandler.postDelayed(myRunnable, 1000);
        }
        super.onResume();
    }
}