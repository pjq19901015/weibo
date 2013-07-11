package com.pjq.weibo;

import android.app.Activity;
import android.os.Bundle;
import com.pjq.common.KeySecret;
import com.pjq.common.RequestURL;
import com.weibo.sdk.android.Weibo;
import com.weibo.sdk.android.WeiboAuthListener;
import com.weibo.sdk.android.WeiboDialogError;
import com.weibo.sdk.android.WeiboException;


/**
 * Created by asus on 13-7-6.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Weibo weibo = Weibo.getInstance(KeySecret.CONSUMERKEY, RequestURL.REDIRECTURL);
        weibo.authorize(SplashActivity.this,new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                String token = bundle.getString(Weibo.KEY_TOKEN);

            }

            @Override
            public void onWeiboException(WeiboException e) {

            }

            @Override
            public void onError(WeiboDialogError weiboDialogError) {

            }

            @Override
            public void onCancel() {

            }
        });
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },3000);*/
    }

}
