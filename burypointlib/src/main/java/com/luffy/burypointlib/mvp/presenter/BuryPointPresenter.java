package com.luffy.burypointlib.mvp.presenter;

import android.content.Context;
import android.os.Build;

import com.luffy.burypointlib.api.ApiClientBuryPoint;
import com.luffy.burypointlib.api.ApiObserverBuryPoint;
import com.luffy.burypointlib.mvp.contract.IBuryPointContract;
import com.luffy.burypointlib.mvp.mode.BuryPointBean;
import com.luffy.generallib.AppUtils;
import com.luffy.generallib.ChannelUtils;
import com.luffy.generallib.DeviceUtils;
import com.luffy.generallib.ValidUtils;
import com.luffy.mvplib.BaseLayerPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lvlufei on 2019/5/24
 *
 * @name 埋点-主持类
 * @desc
 */
public class BuryPointPresenter extends BaseLayerPresenter implements IBuryPointContract.Presenter {

    public BuryPointPresenter() {
        super(null);
    }

    @Override
    public void requestSimulateData() {

    }

    @Override
    public void requestBuryPointGet(Context mContext, String pft, String uid, String ext) {
        String appname = AppUtils.getInstance().getPackName(mContext);
        String cnid = ValidUtils.getInstance().isValid(ChannelUtils.getInstance().getAppMetaData(mContext, "BaiduMobAd_CHANNEL")) ? ChannelUtils.getInstance().getAppMetaData(mContext, "BaiduMobAd_CHANNEL") : "";
        String imei = DeviceUtils.getInstance().getImei(mContext);
        String imsi = DeviceUtils.getInstance().getImsi(mContext);
        String model = DeviceUtils.getInstance().getDeviceModel();
        String mac = DeviceUtils.getInstance().getMacAddress();
        String platform = "Android" + Build.VERSION.SDK_INT;
        String brand = DeviceUtils.getInstance().getDeviceBrand();
        String version = AppUtils.getInstance().getVersionName(mContext);
        ApiClientBuryPoint.getInstance().getApiService()
                .getBuryPoint(appname,
                        cnid,
                        pft,
                        uid,
                        imei,
                        imsi,
                        model,
                        mac,
                        platform,
                        brand,
                        version,
                        ext)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserverBuryPoint<BuryPointBean>());
    }

    @Override
    public void requestBuryPointPost(Context mContext, String pft, String uid, String ext) {
        String appname = AppUtils.getInstance().getPackName(mContext);
        String cnid = ValidUtils.getInstance().isValid(ChannelUtils.getInstance().getAppMetaData(mContext, "BaiduMobAd_CHANNEL")) ? ChannelUtils.getInstance().getAppMetaData(mContext, "BaiduMobAd_CHANNEL") : "";
        String imei = DeviceUtils.getInstance().getImei(mContext);
        String imsi = DeviceUtils.getInstance().getImsi(mContext);
        String model = DeviceUtils.getInstance().getDeviceModel();
        String mac = DeviceUtils.getInstance().getMacAddress();
        String platform = "Android" + Build.VERSION.SDK_INT;
        String brand = DeviceUtils.getInstance().getDeviceBrand();
        String version = AppUtils.getInstance().getVersionName(mContext);
        ApiClientBuryPoint.getInstance().getApiService()
                .postBuryPoint(appname,
                        cnid,
                        pft,
                        uid,
                        imei,
                        imsi,
                        model,
                        mac,
                        platform,
                        brand,
                        version,
                        ext)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserverBuryPoint<BuryPointBean>());
    }
}
