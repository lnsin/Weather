package io.github.kolacbb.kolaweather.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import java.util.List;

import io.github.kolacbb.kolaweather.R;
import io.github.kolacbb.kolaweather.base.BaseFragment;
import io.github.kolacbb.kolaweather.model.HeWeather.Basic;
import io.github.kolacbb.kolaweather.model.HeWeather.DailyForecast;
import io.github.kolacbb.kolaweather.model.HeWeather.HeWeather;
import io.github.kolacbb.kolaweather.model.HeWeather.HeWeatherData;
import io.github.kolacbb.kolaweather.model.HeWeather.Now;
import io.github.kolacbb.kolaweather.net.RetrofitManager;
import io.github.kolacbb.kolaweather.net.service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kolab on 2016/11/5.
 */

public class WeatherFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = WeatherFragment.class.getSimpleName();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView tv_tempra;
    private TextView tv_city;
    private TextView tv_weather;

    public static WeatherFragment getInstance() {
        return new WeatherFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.swipe_refresh_layout);
        tv_tempra = (TextView) mRootView.findViewById(R.id.tv_tempera);
        tv_city = (TextView) mRootView.findViewById(R.id.tv_city);
        tv_weather = (TextView) mRootView.findViewById(R.id.tv_weather);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        onRefresh();
        //mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        WeatherService service = RetrofitManager.getInstance().create(WeatherService.class);
        Call<HeWeather> call = service.getWeatherInfo("CN101010100", "b3ba1d5df02842f6b6529a349338d6da");
        call.enqueue(new Callback<HeWeather>() {
            @Override
            public void onResponse(Call<HeWeather> call, Response<HeWeather> response) {
                mSwipeRefreshLayout.setRefreshing(false);
                if (response.body() == null || response.body().getHeWeatherData() == null || response.body().getHeWeatherData().size() <= 0) {
                    return;
                }
                HeWeatherData data = response.body().getHeWeatherData().get(0);
                Basic basic = data.getBasic();
                String city = basic.getCity();
                Now now = data.getNow();
                String tmp = now.getTmp();
                tv_tempra.setText(tmp+"℃");
                List<DailyForecast> dailyForecast = data.getDailyForecast();
                for (int i = 0; i < dailyForecast.size(); i++) {
                    DailyForecast dailyForecast1 = dailyForecast.get(i);
                    String txtD = dailyForecast1.getCond().getTxtD();
                    tv_weather.setText(txtD);
                 //   String max = dailyForecast1.getTmp().getMax();
                }
                //dailyForecast.get()
                tv_city.setText(city+" | ");
            }

            @Override
            public void onFailure(Call<HeWeather> call, Throwable throwable) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
