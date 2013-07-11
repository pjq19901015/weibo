package com.pjq.net;

import com.pjq.common.RequestURL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pjq
 * Date: 13-7-11
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class GetData {
    static GetData instance = null;

    public static GetData getInstance(){
        if(instance == null){
            synchronized (GetData.class){
                instance = new GetData();
            }
        }
        return instance;
    }
    public String getWeiboListOfHome(String source){
        String string = "";
        Map<String,String> params = new HashMap<String, String>();
        params.put("source",source);
        string = HTTPRequest.getRequest(RequestURL.GET_LASTED,params);
        return string;
    }
}
