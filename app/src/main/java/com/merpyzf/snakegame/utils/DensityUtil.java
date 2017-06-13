package com.merpyzf.snakegame.utils;

import android.content.Context;

/**
 * Created by 春水碧于天 on 2017/6/12.
 */

public class DensityUtil {

    /**
     * 根据手机分辨率从dp转成px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue){

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);

    }

    /**
     * 根据手机分辨率从px转换成dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context,float pxValue){

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5);

    }
}
