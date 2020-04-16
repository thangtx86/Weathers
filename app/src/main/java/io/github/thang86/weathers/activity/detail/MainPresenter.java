package io.github.thang86.weathers.activity.detail;

import java.util.ArrayList;
import java.util.List;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.base.BasePresenter;
import io.github.thang86.weathers.data.model.Address;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter() {

    }

    void loadAddress() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(R.drawable.ic_cloud_white_24_dp, "Da Nang", "29 C", R.drawable.imagea_background));
        addresses.add(new Address(R.drawable.ic_cloud_white_24_dp, "Ha Noi", "30 C", R.drawable.imagea_background));
        addresses.add(new Address(R.drawable.ic_cloud_white_24_dp, "Hue", "34 C", R.drawable.imagea_background));
        addresses.add(new Address(R.drawable.ic_cloud_white_24_dp, "Quang Nam", "28 C", R.drawable.imagea_background));
        addresses.add(new Address(R.drawable.ic_cloud_white_24_dp, "Ho Chi Minh", "28.5 C", R.drawable.imagea_background));
        getMView().loadAddress(addresses);
    }
}
