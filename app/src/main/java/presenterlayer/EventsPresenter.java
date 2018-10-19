package presenterlayer;

import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import modellayer.EventsRepository;
import modellayer.ICallback;
import modellayer.IModelLayer;
import viewlayer.IViewLayer;

public class EventsPresenter implements IPresenterLayer {
    private IViewLayer view;
    private IModelLayer<List<Event>, ICallback<EventBrite>> repository;

    public EventsPresenter(IViewLayer view) {
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
