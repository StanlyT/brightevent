package data.web.retrofit;

import java.util.List;

import data.entities.Event;
import data.entities.EventBrite;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface EventBriteAPI {

    @GET("v3/events/search/?token=GZDC2QIASGL4CZUJA4HJ")
    Call<EventBrite> getEvents();
}
