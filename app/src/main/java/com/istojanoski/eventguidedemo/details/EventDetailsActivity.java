package com.istojanoski.eventguidedemo.details;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.istojanoski.eventguidedemo.R;

/**
 * Created by Ivica on 1/22/2017.
 */

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        if (savedInstanceState == null) {
            EventDetailsFragment eventDetailsFragment = EventDetailsFragment.getInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.container, eventDetailsFragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
