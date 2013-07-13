package com.pjq.util;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: pjq
 * Date: 13-7-12
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public class SharePreferencesDB {
    static SharePreferencesDB sharePreferencesDB = null;
    private Context context;

    public SharePreferencesDB(Context context) {
        this.context = context;
    }

    public static SharePreferencesDB getSharePreferencesDB(Context context){
        if(sharePreferencesDB == null){
            synchronized(SharePreferencesDB.class){
                sharePreferencesDB = new SharePreferencesDB(context);
            }
        }
        return sharePreferencesDB;
    }



}
