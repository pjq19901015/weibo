package com.pjq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.pjq.entity.Status;
import com.pjq.entity.User;
import com.pjq.util.DateFormat;
import com.pjq.util.ImageURLUtil;
import com.pjq.weibo.R;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pjq
 * Date: 13-7-10
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class HomeListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Status>  mStatus;
    private User mUser;
    public HomeListAdapter(Context context, List<Status> status) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mStatus = status;
    }

    @Override
    public int getCount() {
        return mStatus.size();
    }

    @Override
    public Object getItem(int position) {
        return mStatus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if(convertView == null){
            holderView = new HolderView();
            convertView = mInflater.inflate(R.layout.home_listview_item,null);
            getHolderView(holderView,convertView);
            convertView.setTag(holderView);
        }else{
            holderView = (HolderView) convertView.getTag();
        }
        mUser = mStatus.get(position).getUser();
        if(mUser != null){
            holderView.mTxvName.setText(mStatus.get(position).getUser().getName());

        }

        holderView.mTxvRedirect.setText(String.valueOf(mStatus.get(position).getReposts_count()));
        holderView.mTxvContent.setText(mStatus.get(position).getText());
        holderView.mTxvTime.setText(
                DateFormat.getDateTimeByMillisecond(mStatus.get(position).getCreated_at()));
        holderView.mTxvFrom.setText(mStatus.get(position).getSource());
        holderView.mTxvComments.setText(String.valueOf(mStatus.get(position).getComments_count()));
        ImageURLUtil.loadImage(mStatus.get(position).original_pic,
                               holderView.mImgviewContent);
        return convertView;
    }

    private void getHolderView(HolderView holderView,View v){
        holderView.mImgviewHeadPortrait =
                (ImageView) v.findViewById(R.id.home_listview_item_imgview_headportrait);
        holderView.mImgviewCertify =
                (ImageView) v.findViewById(R.id.home_listview_item_imgview_certify);
        holderView.mTxvName =
                (TextView) v.findViewById(R.id.home_listview_item_txv_name);
        holderView.mTxvComments =
                (TextView) v.findViewById(R.id.home_listview_item_txv_comments);
        holderView.mTxvRedirect =
                (TextView) v.findViewById(R.id.home_listview_item_txv_redirect);
        holderView.mTxvContent =
                (TextView) v.findViewById(R.id.home_listview_item_txv_content);
        holderView.mTxvTime =
                (TextView) v.findViewById(R.id.home_listview_item_txv_time);
        holderView.mTxvFrom =
                (TextView) v.findViewById(R.id.home_listview_item_txv_from);
        holderView.mTxvGood =
                (TextView) v.findViewById(R.id.home_listview_item_txv_good);
        holderView.mImgviewCrown =
                (ImageView) v.findViewById(R.id.home_listview_item_imgview_crown);
        holderView.mImgviewContent =
                (ImageView) v.findViewById(R.id.home_listview_item_imgview_content);
    }

    private class HolderView{
        ImageView mImgviewHeadPortrait;
        ImageView mImgviewCertify;
        TextView mTxvName;
        TextView mTxvComments;
        TextView mTxvRedirect;
        TextView mTxvContent;
        ImageView mImgviewCrown;
        ImageView mImgviewContent;
        TextView mTxvTime;
        TextView mTxvFrom;
        TextView mTxvGood;  //点赞的次数
    }
}
