package io.github.thang86.weathers.ui.activity.detail

import io.github.thang86.weathers.core.BaseView
import io.github.thang86.weathers.domain.model.Address

interface MainView:BaseView {
    fun loadAddress(addressList: MutableList<Address>?)
}