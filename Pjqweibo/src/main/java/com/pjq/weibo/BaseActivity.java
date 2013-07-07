package com.pjq.weibo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by asus on 13-7-6.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setContentViewNotitle(int layout){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(layout);
    }
}
