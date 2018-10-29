package model;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import data.web.WebEventsDataSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
    public Single<EventBrite> getEvents(final ICallback<EventBrite> resultCallback) {
        if (isEventsEmpty()) {
            return WebEventsDataSource.getInstance().requestEvents()
                    .doOnSuccess(new Consumer<EventBrite>() {
                        @Override
                        public void accept(EventBrite eventBrite) throws Exception {
                            events = eventBrite.getEvents();
                        }
                    });
        } else {

//            view.updateView(repository.getCacheEvents());
//            view.hideProgressBar();
        }


//        WebEventsDataSource.getInstance().requestEvents(resultEvents -> {
//            List<Event> events = resultEvents.getEvents();
//            init(events);
//            view.updateView(events);
//            view.hideProgressBar();

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
