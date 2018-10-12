package com.example.asus.eventbritelist;

import data.entities.Event;
import data.web.WebEventsDataSource;

import java.util.List;

public class EventsRepository {
    private static final String TAG = "#";
    private static EventsRepository instance;

    private EventsRepository() {
    }

    public static void init() {
        if (instance == null) {
            instance = new EventsRepository();
        }
    }

    public static EventsRepository getInstance() {
        return instance;
    }

    public void getEvents(ICallback<List<Event>> resultEvents ) {
        WebEventsDataSource.getInstance().getEvents(resultEvents);
    }

//    public void getEventsImage(String breedString, ICallback<String> callback) {
//        WebBreedsDataSource.getInstance().getBreedsImage(breedString, callback);
//    }
//
//    public void getEventsName(String breedString, ICallback<String> callback) {
//        WebBreedsDataSource.getInstance().getBreedsImage(breedString, callback);
//    }
//
//    public void getEventsDescription(String breedString, ICallback<String> callback) {
//        WebBreedsDataSource.getInstance().getBreedsImage(breedString, callback);
//    }
}
