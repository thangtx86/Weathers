package io.github.thang86.weathers.ui.activity.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.Places
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import io.github.thang86.weathers.R
import java.util.*


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
