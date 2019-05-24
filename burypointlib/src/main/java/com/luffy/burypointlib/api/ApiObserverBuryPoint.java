package com.luffy.burypointlib.api;

import com.luffy.networklib.api.retrofit.BaseLayerApiObserver;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 网络观察者
 */
public class ApiObserverBuryPoint<T> extends BaseLayerApiObserver<T> {

    @Override
    public void completed() {

    }

    @Override
    public void cacheNetworkData(T t) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void next(T t) {

    }
}