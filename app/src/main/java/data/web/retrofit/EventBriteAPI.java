package data.web.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventBriteAPI {
    @GET("/search/?token=")
    Call<List<String>> getEvents();
}
