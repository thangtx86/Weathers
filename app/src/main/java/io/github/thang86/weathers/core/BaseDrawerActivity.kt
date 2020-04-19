package io.github.thang86.weathers.core

import android.content.Intent
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import io.github.thang86.weathers.ui.activity.search.SearchAreaActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_toolbar.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseDrawerActivity : BaseActivity() {

    companion object {
        private const val SEARCH_AREA_REQUEST_CODE = 1
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        bindViews()
        setNavigationItemSelected()
    }

    fun bindViews() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        btnSearchLocation.setOnClickListener {
            openCloseDrawer(false)
            startActivity()
        }
        btnPrever.setOnClickListener { drawerLayout.closeDrawers() }
    }

    override fun onResume() {
        super.onResume()
        drawerLayout.closeDrawers()
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
        if (toolbar != null) {
            image_other.setOnClickListener {
                openCloseDrawer(false)
            }
        }
    }

    /**
     * open or closed drawer layout
     *  if isBackPress == true when tab button back
     */
    private fun openCloseDrawer(isBackPress: Boolean) {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            if (!isBackPress) {
                drawerLayout.openDrawer(GravityCompat.END)
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