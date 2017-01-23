package com.istojanoski.eventguidedemo.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivica on 1/19/2017.
 */

public class Event implements Parcelable {
    private int EventId;
    private String EventDate;
    private String EventTime;
    private int ArtistID;
    private String ArtistName;
    private String ArtistImage;
    private int ArtiestPopularity;
    private String ArtistTourName;
    private int VenueID;
    private String VenueName;
    private String VenueCity;
    private String VenueCountry;
    private String VenueZipcode;
    private String VenueStreet;
    private String VenuebuildingNumber;
    private float VenueLat;
    private float VanueLong;
    private String VenueImageUrl;

    protected Event(Parcel in) {
        this.EventId = in.readInt();
        this.EventDate = in.readString();
        this.EventTime = in.readString();
        this.ArtistID = in.readInt();
        this.ArtistName = in.readString();
        this.ArtistImage = in.readString();
        this.ArtiestPopularity = in.readInt();
        this.ArtistTourName = in.readString();
        this.VenueID = in.readInt();
        this.VenueName = in.readString();
        this.VenueCity = in.readString();
        this.VenueCountry = in.readString();
        this.VenueZipcode = in.readString();
        this.VenueStreet = in.readString();
        this.VenuebuildingNumber = in.readString();
        this.VenueLat = in.readFloat();
        this.VanueLong = in.readFloat();
        this.VenueImageUrl = in.readString();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int artistID) {
        ArtistID = artistID;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getArtistImage() {
        return ArtistImage;
    }

    public void setArtistImage(String artistImage) {
        ArtistImage = artistImage;
    }

    public int getArtiestPopularity() {
        return ArtiestPopularity;
    }

    public void setArtiestPopularity(int artiestPopularity) {
        ArtiestPopularity = artiestPopularity;
    }

    public String getArtistTourName() {
        return ArtistTourName;
    }

    public void setArtistTourName(String artistTourName) {
        ArtistTourName = artistTourName;
    }

    public int getVenueID() {
        return VenueID;
    }

    public void setVenueID(int venueID) {
        VenueID = venueID;
    }

    public String getVenueName() {
        return VenueName;
    }

    public void setVenueName(String venueName) {
        VenueName = venueName;
    }

    public String getVenueCity() {
        return VenueCity;
    }

    public void setVenueCity(String venueCity) {
        VenueCity = venueCity;
    }

    public String getVenueCountry() {
        return VenueCountry;
    }

    public void setVenueCountry(String venueCountry) {
        VenueCountry = venueCountry;
    }

    public String getVenueZipcode() {
        return VenueZipcode;
    }

    public void setVenueZipcode(String venueZipcode) {
        VenueZipcode = venueZipcode;
    }

    public String getVenueStreet() {
        return VenueStreet;
    }

    public void setVenueStreet(String venueStreet) {
        VenueStreet = venueStreet;
    }

    public String getVenuebuildingNumber() {
        return VenuebuildingNumber;
    }

    public void setVenuebuildingNumber(String venuebuildingNumber) {
        VenuebuildingNumber = venuebuildingNumber;
    }

    public float getVenueLat() {
        return VenueLat;
    }

    public void setVenueLat(float venueLat) {
        VenueLat = venueLat;
    }

    public float getVanueLong() {
        return VanueLong;
    }

    public void setVanueLong(float vanueLong) {
        VanueLong = vanueLong;
    }

    public String getVenueImageUrl() {
        return VenueImageUrl;
    }

    public void setVenueImageUrl(String venueImageUrl) {
        VenueImageUrl = venueImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.EventId);
        dest.writeString(this.EventDate);
        dest.writeString(this.EventTime);
        dest.writeInt(this.ArtistID);
        dest.writeString(this.ArtistName);
        dest.writeString(this.ArtistImage);
        dest.writeInt(this.ArtiestPopularity);
        dest.writeString(this.ArtistTourName);
        dest.writeInt(this.VenueID);
        dest.writeString(this.VenueName);
        dest.writeString(this.VenueCity);
        dest.writeString(this.VenueCountry);
        dest.writeString(this.VenueZipcode);
        dest.writeString(this.VenueStreet);
        dest.writeString(this.VenuebuildingNumber);
        dest.writeFloat(this.VenueLat);
        dest.writeFloat(this.VanueLong);
        dest.writeString(this.VenueImageUrl);
    }

    public Event() {
    }
}
