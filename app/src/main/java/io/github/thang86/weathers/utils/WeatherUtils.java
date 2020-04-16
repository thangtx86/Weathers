package io.github.thang86.weathers.utils;

import android.content.res.Resources;

public class WeatherUtils {

    /**
     * Get height of StatusBar
     *
     * @param resources
     * @return
     */
    public static int getStatusBarHeight(Resources resources) {
        int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
