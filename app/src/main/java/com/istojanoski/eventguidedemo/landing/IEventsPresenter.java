package com.istojanoski.eventguidedemo.landing;

import rx.Subscription;

/**
 * Created by Ivica on 1/22/2017.
 */
public interface IEventsPresenter {

    Subscription displayEvents();
    Subscription displayEventsByDate(String date);
}
