package data.web;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.concurrent.TimeUnit;

import data.entities.Event;
import data.web.retrofit.EventBriteAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class WebEventsDataSource {
    private static final String TAG = "#";
    private static WebEventsDataSource webEventsDataSource;
    private final String BASE_URL = "https://www.eventbriteapi.com/v3/events/";
    private Retrofit instanceRetrofit;
    private EventBriteAPI instanceAPI;

    @SerializedName("events")
    @Expose
    private List<Event> events;

    private WebEventsDataSource() {
        instanceRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(logLevel())
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static WebEventsDataSource getInstance() {
        if (webEventsDataSource == null) {
            webEventsDataSource = new WebEventsDataSource();
        }
        return webEventsDataSource;
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
