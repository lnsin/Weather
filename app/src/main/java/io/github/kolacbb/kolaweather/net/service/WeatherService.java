package io.github.kolacbb.kolaweather.net.service;

import android.support.annotation.Nullable;

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
    @Deprecated
    Call<HeWeather> getWeatherInfo(@Query("cityid") String cityId, @Query("key") String key);


    /**
     * 通过此接口获取城市信息，例如通过名称获取城市ID，建议使用城市ID获取天气数据，避免重名城市导致的混淆
     * @param cityId 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @return
     */
    @GET("search")
    Call getCityInfo(@Query("city") String cityId);

    /**
     * 最长10天天气预报数据（大客户可达14天），天气预报已经包含日出日落，月升月落等常规数据
     *
     * @param city 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @param lang 多语言，默认为中文，可选参数
     */
    @GET("forecast")
    Call getForecaseWeather(@Query("city") String city,
                            @Query("lang") @Nullable String lang);


    /**
     * 包括多种气象指数的实况天气，每小时更新
     *
     * @param city 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @param lang 多语言，默认为中文，可选参数
     */
    @GET("now")
    Call getConstantWeather(@Query("city") String city,
                            @Query("lang") @Nullable String lang);

    /**
     * 最长未来10天每三小时、每一小时天气预报数据
     *
     * @param city 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @param lang 多语言，默认为中文，可选参数
     * @return
     */
    @GET("hourly")
    Call getHourlyWeather(@Query("city") String city,
                          @Query("lang") @Nullable String lang);

    /**
     * 目前提供7大生活指数，每三小时更新
     * @param city 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @return
     */
    @GET("suggestion")
    Call getSuggestionInfo(@Query("city") String city);

    /**
     * 为全国2560个城市灾害预警信息，包括台风、暴雨、暴雪、寒潮、大风、沙尘暴、高温、干旱、雷电、冰雹、
     * 霜冻、霾、道路结冰、寒冷、灰霾、雷电大风、森林火险、降温、道路冰雪、干热风、低温、冰冻等灾害类型。
     * 每15分钟更新一次，建议用户每30-60分钟获取一下信息。
     *
     * @param city 城市名称 city可通过城市中英文名称、ID和IP地址进行，例如city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
     * @return
     */
    @GET("alarm")
    Call getAlarmInfo(@Query("city") String city);


}

