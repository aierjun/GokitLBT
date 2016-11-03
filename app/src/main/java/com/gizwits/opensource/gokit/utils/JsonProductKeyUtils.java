package com.gizwits.opensource.gokit.utils;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by aierJun on 2016/11/1.
 */
public class JsonProductKeyUtils {
    public static String JsonProductKeyUtils(Context context){
        ByteArrayOutputStream bos=null;
        InputStream is = null;
        JSONObject jsonObj=null;
        try {
            is = context.getAssets().open("UIConfig.json");
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream(1024);
            int len = 0;
            while(-1 != (len = is.read(buffer))) {
                bos.write(buffer, 0, len);
            }
            jsonObj = new JSONObject(new String(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String userName = null;
        try {
            userName = jsonObj.getString("product_key");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userName;
    }
}
