package com.auidbook.woodworkingtools.toollist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.auidbook.woodworkingtools.R;
import com.auidbook.woodworkingtools.ToolType;


public class ToolListActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private static final String EXTRA_TOOL_TYPE = "com.auidbook.woodworkingtools.TOOL_TYPE";

    private ToolType mToolType;
    private ViewPager mViewPager;

    public static void startActivity(Context context, ToolType toolType) {
        final Intent intent = new Intent(context, ToolListActivity.class);
        intent.putExtra(EXTRA_TOOL_TYPE, toolType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_list);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolType = (ToolType) getIntent().getSerializableExtra(EXTRA_TOOL_TYPE);
        if (mToolType == null) {
            throw new IllegalStateException("ToolType not available as extra; use startActivity");
        }
        setTitle(mToolType.getToolNameResourceId());

        // Set up tabs
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        final ToolPagerAdapter toolPagerAdapter = new ToolPagerAdapter(getSupportFragmentManager(), getResources(), mToolType);
        tabLayout.setTabsFromPagerAdapter(toolPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mViewPager.setAdapter(toolPagerAdapter);
        tabLayout.setOnTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}