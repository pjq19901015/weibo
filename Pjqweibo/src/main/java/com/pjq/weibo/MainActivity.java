package com.pjq.weibo;

import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.*;
import com.google.gson.Gson;
import com.pjq.adapter.HomeListAdapter;
import com.pjq.entity.Status;
import com.pjq.entity.User;
import com.pjq.interfaces.ActivityInterface;
import com.pjq.net.GetData;
import com.pjq.util.JsonAndObject;
import com.weibo.sdk.android.Oauth2AccessToken;
import com.weibo.sdk.android.WeiboException;
import com.weibo.sdk.android.api.StatusesAPI;
import com.pjq.entity.Status;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ActivityInterface{
    private ListView mLviHome;
    private View mView;
    private HomeListAdapter mHomeListAdapter;
    private LoadHomeDataAsynTask loadHomeDataAsynTask;
    private String mStrToken;
    private Button mBtnShare;
    private List<Status> mStatuses = new ArrayList<Status>();
    private Handler mHanldler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mHomeListAdapter = new HomeListAdapter(MainActivity.this,mStatuses);
                    mLviHome.setAdapter(mHomeListAdapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentViewNotitle(loadTabButton(););
        findView();
        loadTabButton();
        setContentView(mView);
        //Tool.updateFullScreenStatus(this,false);
        initData();
        addAction();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void loadTabButton(){
        LinearLayout linearLayout = (LinearLayout) mView.findViewById(R.id.main_linearlayout_tabbar);
        String[] texts = getResources().getStringArray(R.array.tabbar_btn_text);
        TypedArray images = getResources().obtainTypedArray(R.array.tabbar_btn_image_resource);
        TypedArray ids = getResources().obtainTypedArray(R.array.tabbar_btn_id);
        for(int i = 0; i< images.length(); i++){
            View v = getLayoutInflater().inflate(R.layout.tab_button,null);
            v.setId(ids.getResourceId(i,0));
            ImageView imageview = (ImageView) v.findViewById(R.id.tab_button_imgview);
            TextView textView = (TextView) v.findViewById(R.id.tab_button_txt);
            imageview.setImageDrawable(images.getDrawable(i));
            textView.setText(texts[i]);
            linearLayout.addView(v,
                                 new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                                                               LinearLayout.LayoutParams.FILL_PARENT,
                                                               1));
        }
    }

    @Override
    public void findView() {
        mView = getLayoutInflater().inflate(R.layout.activity_main,null);
        mLviHome = (ListView) mView.findViewById(R.id.home_lvi);
        mBtnShare = (Button) mView.findViewById(R.id.home_titlebar_btn_write_weibo);
    }

    @Override
    public void initData() {
        mStrToken = getIntent().getStringExtra("accesstoken");
        loadHomeDataAsynTask = new LoadHomeDataAsynTask();
    }

    @Override
    public void addAction() {
        loadHomeDataAsynTask.execute();
        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusesAPI statusesAPI = new StatusesAPI(new Oauth2AccessToken(mStrToken));
                //statusesAPI.update("测微博","","",null);
            }
        });
    }

    class LoadHomeDataAsynTask extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected Integer doInBackground(Void... params) {
            String string = GetData.getInstance().getWeiboListOfHome(mStrToken) + " ";
            mStatuses = JsonAndObject.convert(com.pjq.entity.Status.class,string,"statuses");
            Message message = mHanldler.obtainMessage();
            message.what = 1;
            mHanldler.sendMessage(message);
            return null;
        }
    }
}
