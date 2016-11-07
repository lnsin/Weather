package io.github.kolacbb.kolaweather.net;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 添加统一key参数
 * Created by kolab on 2016/11/5.
 */

public class RetrofitManager {
    private static Interceptor sInterceptor;
    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;
    private static final String HE_FENG_URL = "https://free-api.heweather.com/v5/";
    private static final String HE_KEY = "b3ba1d5df02842f6b6529a349338d6da";

    public static Retrofit getInstance() {

        if (sInterceptor == null) {
            sInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    //添加请求参数
                    HttpUrl url=original.url().newBuilder()
                            .addQueryParameter("key", HE_KEY)
                            .build();
                    //添加请求头
                    Request request = original.newBuilder()
                            //.addHeader("Connection", "keep-alive")
                            .method(original.method(), original.body())
                            .url(url)
                            .build();
                    return chain.proceed(request);
                }
            };
        }


        if (sOkHttpClient == null) {
            sOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(sInterceptor)
                    .build();
        }

        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(HE_FENG_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sOkHttpClient)
                    .build();
        }
        return sRetrofit;
    }
}
