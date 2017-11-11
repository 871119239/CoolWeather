package com.example.fandong.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by fandong on 2017/11/11.
 */

public class httpUtil {
     public static void sendOkHttpRequest(String address,okhttp3.Callback callback) {
         OkHttpClient client = new OkHttpClient();
         Request mRequest = new Request.Builder().url(address).build();
         client.newCall(mRequest).enqueue(callback);
     }
}
