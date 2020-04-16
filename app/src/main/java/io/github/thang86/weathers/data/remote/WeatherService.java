package io.github.thang86.weathers.data.remote;

import io.github.thang86.weathers.data.model.City;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather?")
    Call<City> getCity(@Query("q") String movieId, @Query("appid") String appid);
}
