package com.istojanoski.eventguidedemo.network;

import com.squareup.okhttp.OkHttpClient;

import net.jcip.annotations.GuardedBy;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivica on 1/19/2017.
 */

public class HttpClientFactory {

    private static final Object LOCK = new Object();
    private static final long TIMEOUT_IN_MS = 30000;

    @GuardedBy("LOCK")
    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOKHttpClient() {
        synchronized (LOCK) {
            if (mOkHttpClient == null) {
                mOkHttpClient = new OkHttpClient();
                mOkHttpClient.setConnectTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS);
                mOkHttpClient.setReadTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS);
                setCookieHandler();
            }
        }
        return mOkHttpClient;
    }

    private static void setCookieHandler() {
        synchronized (LOCK) {
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
            mOkHttpClient.setCookieHandler(cookieManager);
        }
    }
}
