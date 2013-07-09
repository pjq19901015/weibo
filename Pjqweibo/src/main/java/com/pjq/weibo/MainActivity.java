package com.pjq.weibo;

import android.app.ActionBar;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pjq.tools.Tool;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentViewNotitle(loadTabButton(););
        setContentView(loadTabButton());
        Tool.updateFullScreenStatus(this,false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View loadTabButton(){
        View view = getLayoutInflater().inflate(R.layout.activity_main,null);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.main_linearlayout_tabbar);
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
        return view;
    }
    
}
