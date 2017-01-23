package com.istojanoski.eventguidedemo.landing;

import android.support.annotation.NonNull;

import com.istojanoski.eventguidedemo.entities.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivica on 1/19/2017.
 */

public class EventsParser {

    private static final String ARTISTNAME = "ArtistName";
    private static final String ARTISTIMAGE = "ArtistImage";
    private static final String VENUEIMAGEURL = "VenueImageUrl";
    private static final String EVENTDATE = "EventDate";
    private static final String VENUENAME = "VenueName";

    @NonNull
    public static List<Event> parse(String json) throws JSONException {
        List<Event> events = new ArrayList<Event>();
        JSONArray results = new JSONArray(json);

        for (int i = 0; i < results.length(); i++) {
            events.add(getEvent(results.getJSONObject(i)));
        }

        return events;
    }

    private static Event getEvent(JSONObject result) throws JSONException{
        Event event = new Event();

        if (!result.isNull(ARTISTNAME)) {
            event.setArtistName(result.getString(ARTISTNAME));
        }
        if (!result.isNull(ARTISTIMAGE)) {
            event.setArtistImage(result.getString(ARTISTIMAGE));
        }
        if (!result.isNull(VENUEIMAGEURL)) {
            event.setVenueImageUrl(result.getString(VENUEIMAGEURL));
        }
        if (!result.isNull(EVENTDATE)) {
            event.setEventDate(result.getString(EVENTDATE));
        }
        if (!result.isNull(VENUENAME)) {
            event.setVenueName(result.getString(VENUENAME));
        }

        return event;
    }
}
