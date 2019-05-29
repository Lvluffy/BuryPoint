package com.luffy.burypointlib.mvp.contract;

import android.content.Context;

/**
 * Created by lvlufei on 2019/5/24
 *
 * @name 埋点-契约类
 * @desc
 */
public interface IBuryPointContract {
    interface Presenter {
        /**
         * 请求
         *
         * @param mContext 上下问对象
         * @param pft      大编号
         * @param uid      用户id
         * @param ext      扩展字端 (json格式)
         */
        void requestBuryPoint(Context mContext,
                              String pft,
                              String uid,
                              String ext);
    }
}
