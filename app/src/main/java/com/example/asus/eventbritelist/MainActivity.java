package com.example.asus.eventbritelist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "#~";
    private static final String EVENTS_BUNDLE_KEY = "events_bundle_key";

    private RecyclerView eventsRecyclerView;
    private EventAdapter eventsAdapter;
    private List<Event> events;
    private Drawable divider;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(EVENTS_BUNDLE_KEY, (ArrayList<Event>) events);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (events == null) {
            EventsRepository.init();
            EventsRepository.getInstance().getEvents(new ICallback<EventBrite>() {
                @Override
                public void onResult(EventBrite resultEvents) {
                    events = resultEvents.getEvents();
                    update();
                }
            });
        } else {
            update();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            events = savedInstanceState.getParcelableArrayList(EVENTS_BUNDLE_KEY);
        }

        init(this);
    }

    private void update() {
        eventsAdapter.setEvents(events);
        eventsAdapter.notifyDataSetChanged();
        eventsRecyclerView.setAdapter(eventsAdapter);
    }

    private void init(Context context) {
        eventsAdapter = new EventAdapter(context);
        eventsRecyclerView = findViewById(R.id.recycler_view);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        divider = getResources().getDrawable(R.drawable.item_divider);
        eventsRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration(divider));
    }
}