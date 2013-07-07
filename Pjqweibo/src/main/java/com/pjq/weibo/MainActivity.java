package com.pjq.weibo;

import android.app.ActionBar;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.pjq.tools.Tool;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentViewNotitle(loadTabButton(););
        setContentView(loadTabButton());
        Tool.updateFullScreenStatus(this,false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View loadTabButton(){
        View view = getLayoutInflater().inflate(R.layout.activity_main,null);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.main_linearlayout_tabbar);
        TypedArray images = getResources().obtainTypedArray(R.array.tabbar_btn_image_resource);
        TypedArray ids = getResources().obtainTypedArray(R.array.tabbar_btn_id);
        for(int i = 0; i< images.length(); i++){
            View v = getLayoutInflater().inflate(R.layout.tab_button,null);
            v.setId(ids.getResourceId(i,0));
            ImageView imageview = (ImageView) v.findViewById(R.id.tab_button_imgview);
            imageview.setImageDrawable(images.getDrawable(i));
            linearLayout.addView(v,
                                 new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                                                               LinearLayout.LayoutParams.FILL_PARENT,
                                                               1));
        }
        return view;
    }
    
}
