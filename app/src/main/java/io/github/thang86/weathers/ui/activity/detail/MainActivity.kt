package io.github.thang86.weathers.ui.activity.detail

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.thang86.weathers.R
import io.github.thang86.weathers.adapter.FragmentPageAdapter
import io.github.thang86.weathers.adapter.NavigationAdapter
import io.github.thang86.weathers.core.BaseDrawerActivity
import io.github.thang86.weathers.domain.model.Address
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseDrawerActivity(), MainView {
    private lateinit var adapter: NavigationAdapter
    private var mListAddress: MutableList<Address> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var mAdapterPage: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter.attachView(this)
        presenter.loadAddress()
        bindView()
    }

    private fun bindView() {
        if (mListAddress.isNullOrEmpty()) {
            return
        }
        mAdapterPage = FragmentPageAdapter(supportFragmentManager, this, mListAddress)
        viewpager.adapter = mAdapterPage

    }

    override fun onResume() {
        super.onResume()
        if (mAdapterPage != null) {
            mAdapterPage.notifyDataSetChanged()
        }
    }

    override fun setNavigationItemSelected() {
        // infilate view for item
        adapter = NavigationAdapter(this, mListAddress)
        menurv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        menurv.adapter = adapter

        // set event onclick for item of navigation
        adapter?.setItemClickListener(object : NavigationAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                drawerLayout.closeDrawers()
                viewpager.currentItem = position
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
