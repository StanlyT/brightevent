package com.example.asus.eventbritelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import data.entities.Event;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "#~";

    private RecyclerView eventsRecyclerView;
    private EventAdapter eventsAdapter;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventsAdapter = new EventAdapter(getApplicationContext());
        eventsRecyclerView = findViewById(R.id.recycler_view);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        EventsRepository.init();
        EventsRepository.getInstance().getEvents(new ICallback<List<Event>>(){
            @Override
            public void onResult(List<Event> resultEvents) {
                events = resultEvents;
                eventsAdapter.setEvents(events);
                Log.d(TAG, ""+events.size());
                eventsAdapter.notifyDataSetChanged();
                eventsRecyclerView.setAdapter(eventsAdapter);
            }
        });



    }
}