package io.github.thang86.weathers.core

import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import io.github.thang86.weathers.R

abstract class BaseDrawerActivity: BaseActivity() {

    private lateinit var mDrawer: DrawerLayout
    private lateinit var mNavigationView: NavigationView
    private lateinit var mBtnSeach: ImageView
    companion object{
        private val SEARCH_AREA_REQUEST_CODE = 1

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
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        mNavigationView = findViewById(R.id.nav_view)
        mBtnSeach.setOnClickListener { startActivity() }
    }

     fun startActivity() {
//        val searchLocationIntent: Intent = SearchAreaActivity.newIntent(applicationContext)
//        startActivityForResult(searchLocationIntent, SEARCH_AREA_REQUEST_CODE)
    }

    override fun setupToolbar() {
        super.setupToolbar()
        if (getToolBar()!=null){
            getToolBar().findViewById<ImageView>(R.id.image_other).setOnClickListener{
                openCloseDrawer(false)}
        }
    }

     private fun openCloseDrawer(isBackPress: Boolean) {
         val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
         if (drawer.isDrawerOpen(GravityCompat.END)) {
             drawer.closeDrawer(GravityCompat.END)
         } else {
             if (!isBackPress) {
                 drawer.openDrawer(GravityCompat.END)
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