package io.github.kolacbb.kolaweather.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import io.github.kolacbb.kolaweather.R;
import io.github.kolacbb.kolaweather.base.BaseFragment;
import io.github.kolacbb.kolaweather.model.HeWeather.HeWeather;
import io.github.kolacbb.kolaweather.net.RetrofitManager;
import io.github.kolacbb.kolaweather.net.service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kolab on 2016/11/5.
 */

public class WeatherFragment extends BaseFragment {

    private static final String TAG = WeatherFragment.class.getSimpleName();

    public static WeatherFragment getInstance() {
        return new WeatherFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        WeatherService service = RetrofitManager.getInstance().create(WeatherService.class);
        Call<HeWeather> call = service.getWeatherInfo("CN101010100", "b3ba1d5df02842f6b6529a349338d6da");
        call.enqueue(new Callback<HeWeather>() {
            @Override
            public void onResponse(Call<HeWeather> call, Response<HeWeather> response) {

                Gson gson = new Gson();
                Log.e(TAG, gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<HeWeather> call, Throwable throwable) {

            }
        });
    }
}
