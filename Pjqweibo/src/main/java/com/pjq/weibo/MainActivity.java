package com.pjq.weibo;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.pjq.adapter.HomeListAdapter;
import com.pjq.entity.Status;
import com.pjq.entity.User;
import com.pjq.interfaces.ActivityInterface;
import com.pjq.tools.Tool;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ActivityInterface{
    private ListView mLviHome;
    private View mView;
    private HomeListAdapter mHomeListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentViewNotitle(loadTabButton(););
        mView = getLayoutInflater().inflate(R.layout.activity_main,null);
        setContentView(loadTabButton());
        Tool.updateFullScreenStatus(this,false);
        findView();
        initData();
        addAction();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View loadTabButton(){

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
        return mView;
    }

    @Override
    public void findView() {
        mLviHome = (ListView) mView.findViewById(R.id.home_lvi);
    }

    @Override
    public void initData() {
        List<Status> statuses = new ArrayList<Status>();
        statuses.add(new Status("Tue May 31 17:46:55 +0800 2011",
                                11488058246L,
                                "求关注",
                                "<a href=\"http://weibo.com\" rel=\"nofollow\">新浪微博</a>",
                                new User(11488058246L,"pjq","",null),
                                8,8,
                                "fasdf"));
        mHomeListAdapter = new HomeListAdapter(this,statuses);
    }

    @Override
    public void addAction() {
        mLviHome.setAdapter(mHomeListAdapter);
    }
}
