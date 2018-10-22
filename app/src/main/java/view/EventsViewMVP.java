package view;

public interface EventsViewMVP<T> {
    void updateView(T t);

    void hideProgressBar();

    void showProgressBar();
}
