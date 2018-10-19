package modellayer;

public interface IModelLayer<V, T> {
    void getEvents(T resultEvents);

    void init(V args);

    boolean isEventsEmpty();

    V getCacheEvents();
}
