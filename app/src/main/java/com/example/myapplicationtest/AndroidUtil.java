package com.example.myapplicationtest;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;

@SuppressWarnings({"WeakerAccess", "unused"})
public class AndroidUtil {

    public static float density = Resources.getSystem().getDisplayMetrics().density;
    private static Handler applicationHandler;

    public static Point displaySize = new Point();

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    public static float getAspectRatio() {
        return (float) getScreenHeight() / (float) getScreenWidth();
    }

    public static boolean isTablet(Context context){
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}
