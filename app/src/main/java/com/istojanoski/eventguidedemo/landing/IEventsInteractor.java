package com.istojanoski.eventguidedemo.landing;

import com.istojanoski.eventguidedemo.entities.Event;

import java.util.List;

import rx.Observable;

/**
 * Created by Ivica on 1/22/2017.
 */
public interface IEventsInteractor {

    Observable<List<Event>> fetchEvents();
    Observable<List<Event>> fetchEventsByDate(String date);
}
