package com.luffy.burypointlib.api;

import com.luffy.burypointlib.mvp.mode.BuryPointBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lvlufei on 2017/11/1
 *
 * @desc 网络（Retrofit）服务端
 */
public interface ApiServiceBuryPoint {

    /**
     * 埋点
     *
     * @param appname  app名称
     * @param cnid     app推广渠道
     * @param pft      大编号
     * @param uid      用户id
     * @param imei     移动设备imei号
     * @param imsi     移动设备imsi号
     * @param model    移动设备型号
     * @param mac      mac地址
     * @param platform 操作系统（1-android;2-ios）
     * @param brand    移动设备品牌
     * @param version  APP版本
     * @param ext      扩展字端 (json格式)
     * @return
     */
    @GET(".")
    Observable<BuryPointBean> getBuryPoint(@Query("appname") String appname,
                                           @Query("cnid") String cnid,
                                           @Query("pft") String pft,
                                           @Query("uid") String uid,
                                           @Query("imei") String imei,
                                           @Query("imsi") String imsi,
                                           @Query("model") String model,
                                           @Query("mac") String mac,
                                           @Query("platform") String platform,
                                           @Query("brand") String brand,
                                           @Query("version") String version,
                                           @Query("ext") String ext);

    /**
     * 埋点
     *
     * @param appname  app名称
     * @param cnid     app推广渠道
     * @param pft      大编号
     * @param uid      用户id
     * @param imei     移动设备imei号
     * @param imsi     移动设备imsi号
     * @param model    移动设备型号
     * @param mac      mac地址
     * @param platform 操作系统（1-android;2-ios）
     * @param brand    移动设备品牌
     * @param version  APP版本
     * @param ext      扩展字端 (json格式)
     * @return
     */
    @FormUrlEncoded
    @POST(".")
    Observable<BuryPointBean> postBuryPoint(@Field("appname") String appname,
                                            @Field("cnid") String cnid,
                                            @Field("pft") String pft,
                                            @Field("uid") String uid,
                                            @Field("imei") String imei,
                                            @Field("imsi") String imsi,
                                            @Field("model") String model,
                                            @Field("mac") String mac,
                                            @Field("platform") String platform,
                                            @Field("brand") String brand,
                                            @Field("version") String version,
                                            @Field("ext") String ext);

}
