import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class CurentWeather {


    private static final String API_KEY = "da45a437794f46095faab5cb1438bb4c";
    CurrentWeatherService currentWeatherService;
    Retrofit retrofit;

    CurentWeather() {
        retrofit = createRetrofit();
        currentWeatherService= retrofit.create(CurrentWeatherService.class);
    }


  public String getToClient(String city){
        CompletableFuture<Response<Data>> responseBody = currentWeatherService.getWeather( city, API_KEY, "");
        final String[] result = new String[1];
        responseBody.thenAccept(response -> {
            if (!response.isSuccessful()) {
                result[0] = "Error!";
            } else {
                Data data =  response.body();

               result[0] = data.parse().toString();
            }
        }).join();
        return result[0];
    }

    private static Retrofit createRetrofit() {

        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .addInterceptor(new HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .baseUrl("http://api.openweathermap.org")
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
