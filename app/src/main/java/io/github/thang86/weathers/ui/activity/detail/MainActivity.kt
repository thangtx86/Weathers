package io.github.thang86.weathers.ui.activity.detail

import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import io.github.thang86.weathers.R
import io.github.thang86.weathers.adapter.NavigationAdapter
import io.github.thang86.weathers.core.BaseDrawerActivity
import io.github.thang86.weathers.domain.model.Address

class MainActivity : BaseDrawerActivity(),MainView {
    private lateinit var adapter:NavigationAdapter
    private  var mListAddress:MutableList<Address> = mutableListOf()
    private  lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter.attachView(this)
        presenter.loadAddress()

    }

    override fun setNavigationItemSelected() {
        // infilate view for item
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val vNavigation = findViewById<NavigationView>(R.id.nav_view)
        val recycleView: RecyclerView = vNavigation.findViewById(R.id.menurv)
        adapter = NavigationAdapter(this, mListAddress)
        recycleView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = adapter

        // set event onclick for item of navigation
        adapter?.setItemClickListener(object : NavigationAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                drawerLayout.closeDrawers()
                Toast.makeText(
                    applicationContext,
                    mListAddress[position].address.toString() + " Menu Clicked !",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun loadAddress(addressList: MutableList<Address>?) {
        if (!addressList.isNullOrEmpty()) {
            mListAddress.clear()
            mListAddress.addAll(addressList)
            adapter.notifyDataSetChanged()
        }

    }

}
