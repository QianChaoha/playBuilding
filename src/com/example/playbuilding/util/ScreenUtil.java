package com.example.playbuilding.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ScreenUtil {
    public static int mScreenWidth,mScreenHeight;
    /**
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        float density = dm.density;
        return density;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo pi = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionCode;
        } catch (Exception e) {
        }
        return versionCode;
    }

    public static String getVersionName(Context context) {
        String versionCode = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo pi = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionName;
        } catch (Exception e) {
        }
        return versionCode;
    }


    public static int getMeasuredWidth(View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int measuredWidth = view.getMeasuredWidth();
        return measuredWidth;
    }


    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return boolean
     * @method isEmpty
     */
    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj);
        }
        if (obj instanceof List<?>) {
            List<?> list = (List<?>) obj;
            return list == null || list.size() == 0;
        }
        if (obj instanceof Map<?, ?>) {
            Map<?, ?> map = (Map<?, ?>) obj;
            return map == null || map.size() == 0;
        }
        if (obj instanceof int[]) {
            int[] array = (int[]) obj;
            return array == null || array.length == 0;
        }
        if (obj instanceof float[]) {
            float[] array = (float[]) obj;
            return array == null || array.length == 0;
        }
        if (obj instanceof long[]) {
            long[] array = (long[]) obj;
            return array == null || array.length == 0;
        }
        if (obj instanceof double[]) {
            double[] array = (double[]) obj;
            return array == null || array.length == 0;
        }
        if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            return array == null || array.length == 0;
        }
        if (obj instanceof Object) {
            return obj == null;
        }
        return true;
    }
    public static long getFreeSpace() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize;//区块的大小
        long totalBlocks;//区块总数
        long availableBlocks;//可用区块的数量
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            blockSize = stat.getBlockSizeLong();
            totalBlocks = stat.getBlockCountLong();
            availableBlocks = stat.getAvailableBlocksLong();
        } else {
            blockSize = stat.getBlockSize();
            totalBlocks = stat.getBlockCount();
            availableBlocks = stat.getAvailableBlocks();
        }
        //String totalSpace = Formatter.formatFileSize(MyApplication.getInstance().getApplicationContext(), blockSize * totalBlocks);
        //String availableSpace = Formatter.formatFileSize(MyApplication.getInstance().getApplicationContext(), blockSize * availableBlocks);
        //Log.e(LOG_TAG, "totalSpace：" + totalSpace + "...availableSpace：" + availableSpace);
        return blockSize * availableBlocks;
    }
    public static boolean IsAirModeOn(Context context) {
        return (Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1 ? true : false);
    }
}
