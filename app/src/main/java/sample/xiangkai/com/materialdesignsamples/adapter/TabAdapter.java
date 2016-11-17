package sample.xiangkai.com.materialdesignsamples.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sample.xiangkai.com.materialdesignsamples.fragment.PagerFragment;

/**
 * Created by xiangkai on 2016/11/15.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private static final String TITLE = "tab";
    int count;

    public TabAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return new PagerFragment();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE + position;
    }
}