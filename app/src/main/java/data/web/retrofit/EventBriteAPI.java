package data.web.retrofit;

import data.entities.EventBrite;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface EventBriteAPI {

    @GET("v3/events/search/?token=GZDC2QIASGL4CZUJA4HJ")
    Single<EventBrite> getEvents();
}
