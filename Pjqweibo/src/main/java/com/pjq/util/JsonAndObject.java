package com.pjq.util;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 13-7-13
 * Time: ����9:31
 * To change this template use File | Settings | File Templates.
 */
public class JsonAndObject {

    /**
     *��json�ַ���ת����List
     * @param c    Ҫת���Ķ�����ֽ���
     * @param json ����propertyName���ַ���
     * @param propertyName Ҫת��������
     * @return
     */
    public static List convert(Class c,String json,String propertyName){
        List objs = null;
        if(c == null || json == null){
            return objs;
        }
        Field[] fields = c.getFields();
        if(fields != null){
            try {
                JSONObject jsonObject = new JSONObject(json);
                String strJson = jsonObject.get(propertyName).toString();
                JSONArray jsonArray = new JSONArray(strJson);
                objs = new ArrayList();
                for(int i = 0; i < jsonArray.length(); i++){
                    Object obj = c.newInstance();
                    convertSignleObject(obj,jsonArray.getString(i));
                    objs.add(obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return  objs;
    }

    /**
     * ��json��ʽ������ת��Ϊһ������
     * @param obj
     * @param json
     */
    public static void convertSignleObject(Object obj, String json) {
        if (obj == null || json == null) {
            return;
        }
        Field[] fields = obj.getClass().getFields();
        if(fields != null){
            try {
                JSONObject jsonObject = new JSONObject(json);
                for(Field field : fields){
                    Object value = jsonObject.get(field.getName());
                    if(String.class == field.getType()){
                        field.set(obj,String.valueOf(value));
                    }else if(int.class == field.getType()){
                        field.set(obj,Integer.valueOf(String.valueOf(value)));
                    }else if(long.class == field.getType()){
                        field.set(obj,Long.valueOf(String.valueOf(value)));
                    }else if(boolean.class == field.getType()){
                        field.set(obj,Boolean.valueOf(String.valueOf(value)));
                    }else {
                        Object fieldObj = field.getType().newInstance();
                        convertSignleObject(fieldObj,String.valueOf(value));
                        field.set(obj,fieldObj);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
