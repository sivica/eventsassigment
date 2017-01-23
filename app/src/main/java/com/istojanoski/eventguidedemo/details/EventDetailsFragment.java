package com.istojanoski.eventguidedemo.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.istojanoski.eventguidedemo.R;
import com.istojanoski.eventguidedemo.entities.Event;


/**
 * Created by Ivica on 1/22/2017.
 */
public class EventDetailsFragment extends Fragment implements IEventDetalsView {

    private EventDetailPresenter mEventDetailsPresenter;
    private ImageView mEventImage;
    private TextView mEventTitle;
    private TextView mEventDate;
    private TextView mEventVenue;
    private ImageView mVenueImage;

    public EventDetailsFragment() {
    }

    public static EventDetailsFragment getInstance() {
        return new EventDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventDetailsPresenter = new EventDetailPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_details, container, false);
        setToolbar(rootView);
        init(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventDetailsPresenter.showDetails(getActivity().getIntent().getExtras());
    }

    private void init(View rootView) {
        mEventImage = (ImageView) rootView.findViewById(R.id.event_image);
        mEventTitle = (TextView) rootView.findViewById(R.id.event_title);
        mEventDate = (TextView) rootView.findViewById(R.id.event_date);
        mEventVenue = (TextView) rootView.findViewById(R.id.event_venue);
        mVenueImage = (ImageView) rootView.findViewById(R.id.event_venue_image);
    }

    @Override
    public void showDetails(Event event) {
        Glide.with(getContext()).load(event.getArtistImage()).into(mEventImage);
        mEventTitle.setText(event.getArtistName());
        mEventDate.setText(event.getEventDate());
        mEventVenue.setText(event.getVenueName());
        Glide.with(getContext()).load(event.getVenueImageUrl()).into(mVenueImage);
    }

    private void setToolbar(View rootView) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);

        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        collapsingToolbarLayout.setTitle(getString(R.string.event_details));
        collapsingToolbarLayout.setTitleEnabled(true);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
