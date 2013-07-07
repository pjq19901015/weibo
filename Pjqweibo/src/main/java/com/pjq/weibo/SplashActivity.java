package com.pjq.weibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by asus on 13-7-6.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },3000);
    }
}
