package io.github.thang86.weathers.base;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.activity.search.SearchAreaActivity;

/**
 * ThangTX2
 */
public abstract class BaseDrawerActivity extends BaseActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private ImageView mBtnSeach;
    private static final int SEARCH_AREA_REQUEST_CODE = 1;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
        setNavigationItemSelected();
    }

    @Override
    protected void bindViews() {
        super.bindViews();
        mDrawer = findViewById(R.id.drawer_layout);
        mBtnSeach = findViewById(R.id.btn_search_location);
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mNavigationView = findViewById(R.id.nav_view);
        mBtnSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });
    }

    private void startActivity() {
        Intent searchLocationIntent = SearchAreaActivity.newIntent(getApplicationContext());
        startActivityForResult(searchLocationIntent, SEARCH_AREA_REQUEST_CODE);
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        if (getToolbar() != null) {
            getToolbar().findViewById(R.id.image_other).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openCloseDrawer(false);
                }
            });
        }
    }

    /**
     * Open or Closed Navigation
     *
     * @param isBackPress
     */
    void openCloseDrawer(boolean isBackPress) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            if (!isBackPress) {
                drawer.openDrawer(GravityCompat.END);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onBackPressed() {
        openCloseDrawer(true);
    }

    /**
     * Open or Closed Navigation
     */
    private void openCloseDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.END)) {
//            drawer.closeDrawer(GravityCompat.END);
//        } else {
//            super.onBackPressed();
//        }
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            drawer.openDrawer(GravityCompat.END);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return super.isNetworkConnected();
    }

    public abstract void setNavigationItemSelected();
}
