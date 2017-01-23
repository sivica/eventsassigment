package com.istojanoski.eventguidedemo.landing;

import com.istojanoski.eventguidedemo.entities.Event;
import com.istojanoski.eventguidedemo.constants.Api;
import com.istojanoski.eventguidedemo.network.RequestGenerator;
import com.istojanoski.eventguidedemo.network.RequestHandler;
import com.squareup.okhttp.Request;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Ivica on 1/19/2017.
 */
public class EventsInteractor implements IEventsInteractor {

    @Override
    public Observable <List<Event>> fetchEvents() {
        return Observable.defer(new Func0<Observable<List<Event>>>() {
            @Override
            public Observable<List<Event>> call() {
                try {
                    return Observable.just(get());
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }

            private List<Event> get() throws IOException, JSONException {
                String url = Api.GET_EVENTS;

                Request request = RequestGenerator.get(url);
                String response = RequestHandler.request(request);
                return EventsParser.parse(response);
            }
        });
    }

    @Override
    public Observable<List<Event>> fetchEventsByDate(final String date) {
        return Observable.defer(new Func0<Observable<List<Event>>>() {
            @Override
            public Observable<List<Event>> call() {
                try {
                    return Observable.just(get());
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }

            private List<Event> get() throws IOException, JSONException {
                String url = String.format(Api.GET_EVENTS_BY_DATE , date);

                Request request = RequestGenerator.get(url);
                String response = RequestHandler.request(request);
                return EventsParser.parse(response);
            }
        });
    }
}
