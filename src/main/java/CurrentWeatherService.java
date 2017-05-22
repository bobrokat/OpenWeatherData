import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.concurrent.CompletableFuture;

public interface CurrentWeatherService {
    @FormUrlEncoded
    @POST("/data/2.5/weather")
    CompletableFuture<Response<Data>> getWeather(@Query("q") String city, @Query("APPID") String key, @Field("") String empty);
}
