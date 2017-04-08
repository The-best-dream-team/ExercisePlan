package com.brett.exerciseplan.screens.main;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.brett.exerciseplan.R;
import com.brett.exerciseplan.commons.BaseActivity;
import com.brett.exerciseplan.screens.main.history.HistoryFragment;
import com.brett.exerciseplan.screens.main.home.HomeFragment;
import com.brett.exerciseplan.screens.main.videos.VideoFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.layoutTab)
    TabLayout layoutTab;

    @BindView(R.id.vpPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindButterKnife(this);

        setupViewPager();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private String[] tabNames = {"Home", "History", "Videos"};
    private void setupViewPager(){
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        layoutTab.setupWithViewPager(viewPager);

        for(int i = 0; i < layoutTab.getTabCount(); i++) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_title, null);
            ((TextView)view.findViewById(R.id.tvTabTitle)).setText(tabNames[i]);
            layoutTab.getTabAt(i).setCustomView(view);
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch(position){
                case 0:
                    fragment = new HomeFragment();
                    break;

                case 1:
                    fragment = new HistoryFragment();
                    break;

                case 2:
                    fragment = new VideoFragment();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }
    }
}
