package com.istojanoski.eventguidedemo.landing;

import com.istojanoski.eventguidedemo.entities.Event;

import java.util.List;

/**
 * Created by Ivica on 1/22/2017.
 */
public interface IEventsView {

    void showEvents(List<Event> events);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onEventClicked(Event event);
}
