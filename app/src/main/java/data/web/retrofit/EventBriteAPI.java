package data.web.retrofit;

import data.entities.EventBrite;
import retrofit2.http.GET;
import io.reactivex.Single;

public interface EventBriteAPI {

    @GET("v3/events/search/?token=GZDC2QIASGL4CZUJA4HJ")
    Single<EventBrite> getEvents();
}
