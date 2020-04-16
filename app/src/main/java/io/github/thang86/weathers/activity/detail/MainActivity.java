package io.github.thang86.weathers.activity.detail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.adapter.FragmentPageAdapter;
import io.github.thang86.weathers.adapter.NavigationAdapter;
import io.github.thang86.weathers.base.BaseDrawerActivity;
import io.github.thang86.weathers.data.model.Address;

/**
 * ThangTX2
 */
public class MainActivity extends BaseDrawerActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private FragmentPageAdapter mAdapterPage;
    private List<Address> mListAddress = new ArrayList<>();
    private NavigationAdapter mNavigationAdapter;
    private MainPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mPresenter.loadAddress();
        bindView();

    }

    void bindView() {
        if (mListAddress == null) {
            return;
        }
        mViewPager = findViewById(R.id.viewpager);
        mAdapterPage = new FragmentPageAdapter(getSupportFragmentManager(), this, mListAddress);
        mViewPager.setAdapter(mAdapterPage);

    }


    @Override
    public void setNavigationItemSelected() {

        // infilate view for item
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView vNavigation = (NavigationView) findViewById(R.id.nav_view);
        RecyclerView recycleView = vNavigation.findViewById(R.id.menurv);
        mNavigationAdapter = new NavigationAdapter(this, mListAddress);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(mNavigationAdapter);

        // set event onclick for item of navigation
        mNavigationAdapter.setItemClickListener(position -> {
            drawerLayout.closeDrawers();
            mViewPager.setCurrentItem(position);
            Toast.makeText(MainActivity.this, mListAddress.get(position).getAddress() + " Menu Clicked !", Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("THANGTX2", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("THANGTX2", "onResume: ");
        if (!(mAdapterPage == null)) {
            mAdapterPage.notifyDataSetChanged();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("THANGTX2", "onPause: ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * Load data for view
     *
     * @param addressList
     */
    @Override
    public void loadAddress(List<Address> addressList) {
        mListAddress.clear();
        mListAddress.addAll(addressList);
        mNavigationAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading(String message) {

    }
}





