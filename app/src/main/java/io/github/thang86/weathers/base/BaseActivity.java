package io.github.thang86.weathers.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 *
 * ThangTX2
 */
import io.github.thang86.weathers.R;
import io.github.thang86.weathers.utils.NetworkUtils;

/**
 * ThangTX2
 */
public class BaseActivity extends AppCompatActivity implements BaseView {

    private Toolbar mToolbar;
    private ImageView mIconToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    /**
     * hide status bar
     */
    void hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * init view
     */
    protected void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
        mIconToolbar = findViewById(R.id.image_other);
        setupToolbar();
    }

    /**
     * set content view with inject id
     *
     * @param layoutResId
     */
    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected void setupToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
//            mToolbar.setNavigationIcon(R.drawable.ic_menu);
//            getSupportActionBar().setTitle("");
        }
    }

    /**
     * Method get toolbar
     *
     * @return
     */
    public Toolbar getToolbar() {
        return mToolbar;
    }


    public ImageView getmIconToolbar() {
        return mIconToolbar;
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }
}
