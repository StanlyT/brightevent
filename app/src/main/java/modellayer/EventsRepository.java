package modellayer;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import data.web.WebEventsDataSource;

public class EventsRepository implements IModelLayer<List<Event>, ICallback<EventBrite>> {
    private static EventsRepository instance;
    private List<Event> events;

    private EventsRepository() {
    }

    public static EventsRepository getInstance() {
        if (instance == null) {
            instance = new EventsRepository();
            instance.events = new ArrayList<>();
        }
        return instance;
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
