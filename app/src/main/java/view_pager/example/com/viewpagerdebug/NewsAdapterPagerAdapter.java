package view_pager.example.com.viewpagerdebug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 20.11.15.
 */
public class NewsAdapterPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> mFragments = new ArrayList<Fragment>();

    public NewsAdapterPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(ArticleFragment.newInstance(0));
        mFragments.add(ArticleFragment.newInstance(1));
        mFragments.add(ArticleFragment.newInstance(2));
        mFragments.add(ArticleFragment.newInstance(3));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
