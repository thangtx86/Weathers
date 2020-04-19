package io.github.thang86.weathers.core

import android.content.Intent
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import io.github.thang86.weathers.R
import io.github.thang86.weathers.ui.activity.search.SearchAreaActivity

abstract class BaseDrawerActivity : BaseActivity() {

    open lateinit var mDrawer: DrawerLayout
    private lateinit var mNavigationView: NavigationView
    private lateinit var mBtnSeach: ImageView

    companion object {
        private const val SEARCH_AREA_REQUEST_CODE = 1
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        bindViews()
        setNavigationItemSelected()
    }

    override fun bindViews() {
        super.bindViews()
        mDrawer = findViewById(R.id.drawer_layout)
        mBtnSeach = findViewById(R.id.btn_search_location)
        val btnPrev = findViewById<ImageView>(R.id.btn_prever)
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        mNavigationView = findViewById(R.id.nav_view)
        mBtnSeach.setOnClickListener {
            openCloseDrawer(false)
            startActivity()
        }
        btnPrev.setOnClickListener { mDrawer.closeDrawers() }
    }

    override fun onResume() {
        super.onResume()
        mDrawer.closeDrawers()
    }

    /**
     * Open SearchArea screen
     */
    private fun startActivity() {
        val searchLocationIntent: Intent = SearchAreaActivity.newIntent(applicationContext)
        startActivityForResult(searchLocationIntent, SEARCH_AREA_REQUEST_CODE)
    }

    override fun setupToolbar() {
        super.setupToolbar()
        if (getToolBar() != null) {
            getToolBar().findViewById<ImageView>(R.id.image_other).setOnClickListener {
                openCloseDrawer(false)
            }
        }
    }

    /**
     * open or closed drawer layout
     *  if isBackPress == true when tab button back
     */
    private fun openCloseDrawer(isBackPress: Boolean) {
        if (mDrawer.isDrawerOpen(GravityCompat.END)) {
            mDrawer.closeDrawer(GravityCompat.END)
        } else {
            if (!isBackPress) {
                mDrawer.openDrawer(GravityCompat.END)
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        openCloseDrawer(true)
    }

    abstract fun setNavigationItemSelected()

}