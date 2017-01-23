package com.istojanoski.eventguidedemo.network;

import android.support.annotation.NonNull;

import com.squareup.okhttp.Request;

/**
 * Created by Ivica on 1/19/2017.
 */

public class RequestGenerator {

    public static Request get(@NonNull String url) {
        Request.Builder builder = new Request.Builder().url(url);
        addDefaultHeader(builder);
        return builder.build();
    }

    private static void addDefaultHeader(@NonNull Request.Builder builder) {
        builder.header("Accept", "application/json");
    }
}
