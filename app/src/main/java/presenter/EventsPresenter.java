package presenter;

import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import model.EventsRepository;
import model.ICallback;
import model.EventsModelMVP;
import view.EventsViewMVP;

public class EventsPresenter implements EventPresenterMVP {
    private EventsViewMVP view;
    private EventsModelMVP<List<Event>, ICallback<EventBrite>> repository;

    public EventsPresenter(EventsViewMVP view) {
        this.view = view;
        repository = EventsRepository.getInstance();
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
