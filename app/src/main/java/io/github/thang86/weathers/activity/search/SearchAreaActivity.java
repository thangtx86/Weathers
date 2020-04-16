package io.github.thang86.weathers.activity.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.base.BaseActivity;

public class SearchAreaActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_area);

    }

    public static Intent newIntent(Context applicationContext) {
        return new Intent(applicationContext, SearchAreaActivity.class);
    }
}
