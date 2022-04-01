package com.example.myapplicationtest;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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


}
