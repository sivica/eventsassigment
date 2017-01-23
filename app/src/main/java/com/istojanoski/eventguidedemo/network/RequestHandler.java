package com.istojanoski.eventguidedemo.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Ivica on 1/19/2017.
 */
public class RequestHandler {

    public static String request(Request request) throws IOException {
        OkHttpClient httpClient = HttpClientFactory.getOKHttpClient();
        Response response = httpClient.newCall(request).execute();
        String body = response.body().string();

        if (response.isSuccessful()) {
            return body;
        } else {
            throw new RuntimeException(response.message());
        }
    }
}
