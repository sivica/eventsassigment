package com.istojanoski.eventguidedemo.landing;


import com.istojanoski.eventguidedemo.entities.Event;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by Ivica on 1/22/2017.
 */

public class EventsPresenter implements IEventsPresenter {

    private IEventsInteractor mEventsInteractor;
    private IEventsView mEventsView;

    public EventsPresenter(IEventsView eventsView) {
        mEventsView = eventsView;
        mEventsInteractor = new EventsInteractor();
    }

    @Override
    public Subscription displayEvents() {
        return mEventsInteractor.fetchEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mEventsView.loadingStarted();
                    }
                })
                .subscribe(new Subscriber<List<Event>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mEventsView.loadingFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Event> events) {
                        mEventsView.showEvents(events);
                    }
                });
    }

    @Override
    public Subscription displayEventsByDate(String date) {
        return mEventsInteractor.fetchEventsByDate(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mEventsView.loadingStarted();
                    }
                })
                .subscribe(new Subscriber<List<Event>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mEventsView.loadingFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Event> events) {
                        mEventsView.showEvents(events);
                    }
                });
    }
}
