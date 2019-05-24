package com.luffy.burypointlib.api;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lvlufei on 2017/11/1
 *
 * @desc 网络（Retrofit）客户端
 */
public class ApiClientBuryPoint {
    /*默认延时时间*/
    private static final long DEFAULT_TIME_OUT = 30 * 1000;
    private static Retrofit mRetrofit;

    private ApiClientBuryPoint() {
    }

    public static ApiClientBuryPoint getInstance() {
        return RetrofitClientHelper.mApiClientBuryPoint;
    }

    private static class RetrofitClientHelper {
        private static ApiClientBuryPoint mApiClientBuryPoint;

        static {
            mApiClientBuryPoint = new ApiClientBuryPoint();
        }
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//连接超时时间
            builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//写操作超时时间
            builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//读操作超时时间
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .baseUrl("http://log.xiaoxiedu.com")
                    .build();
        }
        return mRetrofit;
    }

    public ApiServiceBuryPoint getApiService() {
        return getRetrofit().create(ApiServiceBuryPoint.class);
    }
}
