package io.github.thang86.weathers.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.activity.detail.WeatherFragment;
import io.github.thang86.weathers.data.model.Address;

public class FragmentPageAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 1;
    private final Context mContext;
    private List<Address> mAddress;

    public FragmentPageAdapter(FragmentManager fragmentManager, Context context, int item_count) {
        super(fragmentManager);
        NUM_ITEMS = item_count;
        mContext = context;
    }

    public FragmentPageAdapter(FragmentManager fragmentManager, Context context, List<Address> addresses) {
        super(fragmentManager);
        NUM_ITEMS = addresses.size();
        this.mContext = context;
        this.mAddress = addresses;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return WeatherFragment.newInstance(mAddress.get(position));
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(R.string.tab) + " " + String.valueOf(position + 1);
    }
}
