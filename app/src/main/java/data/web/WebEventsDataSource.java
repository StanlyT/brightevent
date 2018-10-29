package data.web;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import data.entities.EventBrite;
import data.web.retrofit.EventBriteAPI;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import model.ICallback;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebEventsDataSource {
    private static volatile WebEventsDataSource instance;
    private EventBriteAPI webAPI;

    private WebEventsDataSource() {
        String BASE_URL = "https://www.eventbriteapi.com/";
        Retrofit instanceRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(logLevel())
                .build();
        webAPI = instanceRetrofit.create(EventBriteAPI.class);
    }

    public static WebEventsDataSource getInstance() {
        WebEventsDataSource localInstance = instance;
        if (localInstance == null) {
            synchronized (WebEventsDataSource.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new WebEventsDataSource();
                }
            }
        }
        return localInstance;
    }

    public Single<EventBrite> requestEvents() {
        return webAPI.getEvents();
//        single.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(eventBrite ->
//                        resultCallback.onResult(eventBrite), throwable -> {
//                });
    }

    private static OkHttpClient logLevel() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }
}
