package com.iheb.tourguideapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.m_view_pager);
        tab = findViewById(R.id.m_tab);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        tab.setupWithViewPager(pager);
    }
    public class ViewPagerAdapter extends FragmentPagerAdapter{
        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new Hotels();
                case 1:
                    return new Restaurents();
                case 2:
                    return new Cafes();
                case 3:
                    return new Shop();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return getString(R.string.hotels);
                case 1:
                    return getString(R.string.restaurants);
                case 2:
                    return getString(R.string.cafes);
                case 3:
                    return getString(R.string.shop);
            }
            return super.getPageTitle(position);
        }
    }
}
