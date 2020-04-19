package io.github.thang86.weathers.ui.activity.search

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.thang86.weathers.R

class SearchAreaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_area)
    }

    companion object{
        fun newIntent( applicationContext:Context): Intent{
            return Intent(applicationContext,SearchAreaActivity::class.java)
        }
    }
}
