package presenter;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import model.EventsRepository;
import model.ICallback;
import model.EventsModelMVP;
import view.EventsActivity;
import view.EventsViewMVP;

public class EventsPresenter implements EventPresenterMVP<EventsViewMVP> {
    private EventsViewMVP view;
    private EventsModelMVP<List<Event>, ICallback<EventBrite>> repository;

    public EventsPresenter(EventsRepository model) {
        repository = model;
    }

    @Override
    public void bind(EventsViewMVP view) {
        this.view = view;
        repository = EventsRepository.getInstance();
    }

    @Override
    public void unBind() {
        view = null;
    }

    @Override
    public void loadEvents() {
        view.showProgressBar();
        if (repository.isEventsEmpty()) {
            repository.getEvents(resultEvents -> {
                List<Event> events = resultEvents.getEvents();
                repository.init(events);
                view.updateView(events);
                view.hideProgressBar();
            });
        } else {
            view.updateView(repository.getCacheEvents());
            view.hideProgressBar();
        }
    }
}


//
//    @Override
//    public void loadEvents() {
//        view.showProgressBar();
//        if (repository.isEventsEmpty()) {
//            repository.getEvents(resultEvents -> {
//                List<Event> events = resultEvents.getEvents();
//                repository.init(events);
//                view.updateView(events);
//                view.hideProgressBar();
//            });
//        } else {
//            view.updateView(repository.getCacheEvents());
//            view.hideProgressBar();
//        }
//    }

