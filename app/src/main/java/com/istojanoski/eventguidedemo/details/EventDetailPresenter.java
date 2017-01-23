package com.istojanoski.eventguidedemo.details;

import android.os.Bundle;

import com.istojanoski.eventguidedemo.constants.Constants;
import com.istojanoski.eventguidedemo.entities.Event;

/**
 * Created by Ivica on 1/23/2017.
 */
public class EventDetailPresenter {

    private final IEventDetalsView mEventDetailsView;

    public EventDetailPresenter(IEventDetalsView eventDetailsView) {
        mEventDetailsView = eventDetailsView;
    }

    public void showDetails(Bundle extras) {
        Event event = extras.getParcelable(Constants.EVENT);
        mEventDetailsView.showDetails(event);
    }
}
