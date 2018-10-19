package viewlayer;

public interface IViewLayer<T> {
    void updateView(T t);

    void hideProgressBar();

    void showProgressBar();
}
