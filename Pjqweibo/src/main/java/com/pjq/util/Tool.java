package com.pjq.util;

import android.app.Activity;
import android.view.WindowManager;

/**
 * Created by asus on 13-7-6.
 */
public class Tool {
    public static void updateFullScreenStatus(Activity activity, Boolean isFullScreen){
        if(isFullScreen){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }else{
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
