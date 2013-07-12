package com.pjq.weibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.pjq.common.KeySecret;
import com.pjq.common.RequestURL;
import com.weibo.sdk.android.*;


/**
 * Created by asus on 13-7-6.
 */
public class SplashActivity extends Activity {
    private  Weibo weibo;
    private  String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weibo = Weibo.getInstance(KeySecret.CONSUMERKEY, RequestURL.REDIRECTURL);
        weibo.authorize(SplashActivity.this,new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                token = bundle.getString(Weibo.KEY_TOKEN);
                //weibo.accessToken = new Oauth2AccessToken(token);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        intent.putExtra("accesstoken",token);
                        startActivity(intent);
                        SplashActivity.this.finish();
                    }
                }, 3000);
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

    }

}
