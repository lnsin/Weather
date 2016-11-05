package io.github.kolacbb.kolaweather.net.service;

import io.github.kolacbb.kolaweather.model.HeWeather.HeWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kolab on 2016/11/5.
 */

public interface WeatherService {

    /**
     * 获取天气接口 https://api.heweather.com/x3/weather?cityid=CN101010100&key=b3ba1d5df02842f6b6529a349338d6da
     * 北京ID：CN101010100
     * key : b3ba1d5df02842f6b6529a349338d6da
     */
    @GET("weather")
    Call<HeWeather> getWeatherInfo(@Query("cityid") String cityId, @Query("key") String key);
}
