package io.github.thang86.weathers.data.model;

import android.graphics.drawable.Drawable;

/**
 *
 * ThangTX2
 */
public class DrawerItem {

    private Drawable drawable;
    private String title;
    private String color;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
