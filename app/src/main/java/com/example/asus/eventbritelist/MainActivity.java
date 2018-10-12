package com.example.asus.eventbritelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import data.entities.Event;

public class MainActivity extends AppCompatActivity {
    private RecyclerView eventsRecyclerView;
    private EventAdapter eventsAdapter;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventsRecyclerView = findViewById(R.id.recycler_view);

        EventsRepository.init();
        EventsRepository.getInstance().getEvents(new ICallback<List<Event>>(){
            @Override
            public void onResult(List<Event> resultEvents) {
                events = resultEvents;
            }
        });

        eventsAdapter = new EventAdapter(this);
        eventsAdapter.setEvents(events);
        eventsRecyclerView.setAdapter(eventsAdapter);

    }
}