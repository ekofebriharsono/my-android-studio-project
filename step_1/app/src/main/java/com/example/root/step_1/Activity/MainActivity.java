package com.example.root.step_1.Activity;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.root.step_1.Adapter.SectionsPageAdapter;
import com.example.root.step_1.Fragment.Fragment_Tab_1;
import com.example.root.step_1.Fragment.Fragment_Tab_2;
import com.example.root.step_1.Fragment.Fragment_Tab_3;
import com.example.root.step_1.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Tab_1(), "Print");
        adapter.addFragment(new Fragment_Tab_2(), "Fotocopy");
        adapter.addFragment(new Fragment_Tab_3(), "TAB3");
        viewPager.setAdapter(adapter);
    }
}