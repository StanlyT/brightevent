package com.example.asus.eventbritelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private static final String TAG = "#~";

    private Context context;
    private List<Event> events;

    EventAdapter(Context context){
        this.context = context;
    }

    public void setEvents(List<Event> events){
        this.events = new ArrayList<>();
        this.events = events;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount() "+events.size());
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Event event;
        private TextView name_textview;
        private TextView description_textview;
        private ImageView logo_image_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        public void initViews(View view) {
            name_textview = view.findViewById(R.id.name_textview);
            description_textview = view.findViewById(R.id.description_textview);
            logo_image_view = view.findViewById(R.id.logo_image_view);
        }

        public void setData(int position) {
            event = events.get(position);
            name_textview.setText(event.getName().getText());
            description_textview.setText(event.getDescription().getText());
        }
    }
}
