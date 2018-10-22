package model;

public interface EventsModelMVP<V, T> {
    void getEvents(T resultEvents);

    void init(V args);

    boolean isEventsEmpty();

    V getCacheEvents();
}
