package io.github.thang86.weathers.activity.detail;

import java.util.List;

import io.github.thang86.weathers.base.BaseView;
import io.github.thang86.weathers.data.model.Address;

public interface MainView extends BaseView {
    void showLoading();

    void hideLoading();

    void loadAddress(List<Address> addressList);

    void onErrorLoading(String message);
}
