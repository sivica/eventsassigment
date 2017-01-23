package com.istojanoski.eventguidedemo.landing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.istojanoski.eventguidedemo.R;
import com.istojanoski.eventguidedemo.entities.Event;

import java.util.List;

/**
 * Created by Ivica on 1/19/2017.
 */
public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder> {

    private final List<Event> mEvents;
    private final IEventsView mEventsView;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final ImageView mEventImage;
        private final TextView mEventTitle;
        private Event mEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.event_image);
            mEventTitle = (TextView) itemView.findViewById(R.id.event_title);
        }

        @Override
        public void onClick(View v) {
            mEventsView.onEventClicked(mEvent);
        }
    }

    public EventsListAdapter(List<Event> events, IEventsView eventsView) {
        mEvents = events;
        mEventsView = eventsView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.event_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.mEvent = mEvents.get(position);
        holder.mEventTitle.setText(holder.mEvent.getArtistName());
        Glide.with(mContext).load(holder.mEvent.getArtistImage())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.mEventImage);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }
}
