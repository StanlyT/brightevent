package presenter;

import view.EventsViewMVP;

public interface EventPresenterMVP <T extends EventsViewMVP>{
    void bind(T t);
    void unBind();
    void loadEvents();
}
