package data.web;

import com.example.asus.eventbritelist.ICallback;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import data.entities.Event;
import data.entities.EventBrite;
import data.web.retrofit.EventBriteAPI;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//import rx.schedulers.Schedulers;

public class WebEventsDataSource {
    private static final String TAG = "#~";
    private static WebEventsDataSource webEventsDataSource;
    private final String BASE_URL = "https://www.eventbriteapi.com/";
    private Retrofit instanceRetrofit;
    private EventBriteAPI webAPI;

    @SerializedName("events")
    @Expose
    private List<Event> events;

    private WebEventsDataSource() {
        instanceRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(logLevel())
                .build();
        webAPI = instanceRetrofit.create(EventBriteAPI.class);
        events = new ArrayList<>();
    }

    public static WebEventsDataSource getInstance() {
        if (webEventsDataSource == null) {
            webEventsDataSource = new WebEventsDataSource();
        }
        return webEventsDataSource;
    }

    public void getEvents(final ICallback<EventBrite> resultCallback) {
        Single<EventBrite> single = webAPI.getEvents();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(eventBrite ->
                        resultCallback.onResult(eventBrite), throwable -> {
                });
    }

    private static OkHttpClient logLevel() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        return client;
    }
}
