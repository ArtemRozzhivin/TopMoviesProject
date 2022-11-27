package app.com.moviedb.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import app.com.moviedb.UI.Fragments.TopRatedFragment;


public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TopRatedFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
