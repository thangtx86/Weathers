package io.github.thang86.weathers.data.remote;

import io.github.thang86.weathers.BuildConfig;

public class ApiUtils {
    public static WeatherService getMoviePopularRespone() {
        return ApiClient.getApiClient(BuildConfig.BASE_URL).create(WeatherService.class);
    }
}
