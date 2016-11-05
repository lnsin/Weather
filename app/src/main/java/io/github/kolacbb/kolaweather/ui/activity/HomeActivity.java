package io.github.kolacbb.kolaweather.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.kolacbb.kolaweather.R;
import io.github.kolacbb.kolaweather.base.BaseActivity;
import io.github.kolacbb.kolaweather.ui.fragment.WeatherFragment;

/**
 * Created by kolab on 2016/11/5.
 */

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, WeatherFragment.getInstance())
                .commit();
    }
}
