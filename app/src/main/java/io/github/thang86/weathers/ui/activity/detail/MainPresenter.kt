package io.github.thang86.weathers.ui.activity.detail

import io.github.thang86.weathers.R
import io.github.thang86.weathers.core.BasePresenter
import io.github.thang86.weathers.domain.model.Address

class MainPresenter : BasePresenter<MainView>() {
    fun loadAddress() {
        val addresses: MutableList<Address> = mutableListOf()
        addresses.add(
            Address(
                R.drawable.ic_cloud_white_24_dp,
                "Da Nang",
                "29 C",
                R.drawable.imagea_background
            )
        )
        addresses.add(
            Address(
                R.drawable.ic_cloud_white_24_dp,
                "Ha Noi",
                "30 C",
                R.drawable.imagea_background
            )
        )
        addresses.add(
            Address(
                R.drawable.ic_cloud_white_24_dp,
                "Hue",
                "34 C",
                R.drawable.imagea_background
            )
        )
        addresses.add(
            Address(
                R.drawable.ic_cloud_white_24_dp,
                "Quang Nam",
                "28 C",
                R.drawable.imagea_background
            )
        )
        addresses.add(
            Address(
                R.drawable.ic_cloud_white_24_dp,
                "Ho Chi Minh",
                "28.5 C",
                R.drawable.imagea_background
            )
        )

        getMView()?.loadAddress(addresses)
    }
}