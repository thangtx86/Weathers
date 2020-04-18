package io.github.thang86.weathers.core

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import io.github.thang86.weathers.R

open class BaseActivity: AppCompatActivity(),BaseView {

    private lateinit var mToolBar: Toolbar
    private lateinit var mIconToolbar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        bindViews()
    }

    /**
     * init view
     */
    open fun bindViews() {
        mToolBar = findViewById<Toolbar>(R.id.toolbar)
        mIconToolbar = findViewById(R.id.image_other)
        setupToolbar()
    }

    open fun setupToolbar() {
        if (this.mToolBar != null) {
            setSupportActionBar(mToolBar)
        }
    }

    open fun getToolBar():Toolbar{
        return mToolBar
    }

    private fun hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }


}