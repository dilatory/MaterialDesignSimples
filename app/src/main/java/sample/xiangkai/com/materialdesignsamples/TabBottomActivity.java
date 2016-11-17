package sample.xiangkai.com.materialdesignsamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.xiangkai.com.materialdesignsamples.adapter.TabAdapter;

/**
 * Created by xiangkai on 2016/11/15.
 */
public class TabBottomActivity extends AppCompatActivity {
    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    int count = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bottom);
        ButterKnife.bind(this);

        setupViewPager();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);
        for (int i = 0; i < count; i++) {
            tabLayout.getTabAt(i).setCustomView(R.layout.view_tab_image_title);
            TextView tvTitle = (TextView) tabLayout.getTabAt(i).getCustomView().findViewById(R.id.tv_tab);
            tvTitle.setText("Tab" + i);
        }
    }

    private void setupViewPager() {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), count);
        viewPager.setAdapter(adapter);
    }
}
