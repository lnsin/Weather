package io.github.kolacbb.kolaweather.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * https://api.heweather.com/x3/weather?cityid=城市ID&key=你的认证key 和风天气URL
 *
 *
 * Created by kolab on 2016/11/5.
 */

public class RetrofitManager {
    private static Retrofit mRetrofit;
    private static final String HE_FENG_URL = "https://api.heweather.com/x3/";

    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(HE_FENG_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
