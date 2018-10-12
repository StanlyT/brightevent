package data.web;

import android.util.Log;

import com.example.asus.eventbritelist.ICallback;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import data.entities.Event;
import data.entities.EventBrite;
import data.web.retrofit.EventBriteAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public void getEvents(final ICallback<List<Event>> resultCallback) {
        Call<EventBrite> call = webAPI.getEvents();
        call.enqueue(new Callback<EventBrite>() {
            @Override
            public void onResponse(Call<EventBrite> call, Response<EventBrite> response) {
                if (response.isSuccessful()) {
                    events = response.body().getEvents();
                    Log.d(TAG, "Response list size "
                            + (response != null ? events.size() : 0));

                    resultCallback.onResult(events);
                } else {
                    Log.d(TAG, "onResponse: response was not successful");
                }
            }

            @Override
            public void onFailure(Call<EventBrite> call, Throwable t) {
                Log.d(TAG, "onFailure");
                t.printStackTrace();
            }
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
