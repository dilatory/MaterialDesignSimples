package sample.xiangkai.com.materialdesignsamples;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.xiangkai.com.materialdesignsamples.fragment.FABDrawerFragment;

/**
 * Created by xiangkai on 2016/11/15.
 */
public class FABDrawerActivity extends AppCompatActivity {
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;

    @OnClick(R.id.fab)
    void onClick() {
        Snackbar.make(viewPager, "snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        ButterKnife.bind(this);

        setupDrawer();
        setupViewPager();
        setupTabLayout();
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //如何将toobar左上角图标变为白色 遗留问题
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new FABDrawerFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "TAB" + position;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
