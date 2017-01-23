package com.istojanoski.eventguidedemo.landing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.istojanoski.eventguidedemo.R;
import com.istojanoski.eventguidedemo.constants.Constants;
import com.istojanoski.eventguidedemo.details.EventDetailsActivity;
import com.istojanoski.eventguidedemo.entities.Event;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by Ivica on 1/19/2017.
 */

public class EventsFragment extends Fragment implements IEventsView, CalendarDatePickerDialogFragment.OnDateSetListener {

    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";
    private RecyclerView mEventsList;
    private GridLayoutManager mLayoutManager;
    private EventsListAdapter mAdapter;
    private ArrayList<Event> mEvents = new ArrayList<>();
    private Subscription mEventsSubscription;
    private EventsPresenter mEventsPresenter;

    public EventsFragment() {

    }

    public static EventsFragment newInstance() {
        return new EventsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventsPresenter = new EventsPresenter(this);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        init(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventsSubscription = mEventsPresenter.displayEvents();
    }

    private void init(View rootView) {
        mEventsList = (RecyclerView) rootView.findViewById(R.id.events_list);
        mEventsList.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mEventsList.setLayoutManager(mLayoutManager);

        mAdapter = new EventsListAdapter(mEvents, this);
        mEventsList.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        if (mEventsSubscription != null && !mEventsSubscription.isUnsubscribed()) {
            mEventsSubscription.unsubscribe();
        }
        super.onDestroyView();
    }

    @Override
    public void showEvents(List<Event> events) {
        mEvents.clear();
        mEvents.addAll(events);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadingStarted() {
        Toast.makeText(getContext(), R.string.loading_events, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadingFailed(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEventClicked(Event event) {
        Intent intent = new Intent(getActivity(), EventDetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(Constants.EVENT, event);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pick_date:
                showCalendar();
            case android.R.id.home:
                backToAllEvents();
        }

        return super.onOptionsItemSelected(item);
    }

    private void backToAllEvents() {
        mEventsPresenter.displayEvents();
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle(R.string.events);
        }
    }

    private void showCalendar() {
        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setThemeLight()
                .setOnDateSetListener(EventsFragment.this);
        cdp.show(getActivity().getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear++;
        String monthOfYearString = String.valueOf(monthOfYear).length() == 1 ? "0" + monthOfYear : String.valueOf(monthOfYear);
        String dayOfMonthString = String.valueOf(dayOfMonth).length() == 1 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
        mEventsPresenter.displayEventsByDate(String.valueOf(year) + monthOfYearString + dayOfMonthString);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.calendar_date_picker_result_values, year, monthOfYear, dayOfMonth));
        }
    }
}
