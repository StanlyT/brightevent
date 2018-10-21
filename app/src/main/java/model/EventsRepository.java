package model;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import data.web.WebEventsDataSource;

public class EventsRepository implements EventsModelMVP<List<Event>, ICallback<EventBrite>> {
    private static volatile EventsRepository instance;
    private List<Event> events;

    private EventsRepository() {
    }

    public static EventsRepository getInstance() {
        EventsRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (EventsRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new EventsRepository();
                    localInstance.events = new ArrayList<>();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void getEvents(ICallback<EventBrite> resultEvents) {
        WebEventsDataSource.getInstance().requestEvents(resultEvents);
    }

    @Override
    public void init(List<Event> args) {
        events = args;
    }

    @Override
    public boolean isEventsEmpty() {
        return events.isEmpty();
    }

    @Override
    public List<Event> getCacheEvents() {
        return events;
    }
}
