package com.auidbook.prototype;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    private static final String SELECTED_POSITION = "selectedPosition";

    private int mCurrentNavPosition;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ToolType[] mToolTypes = ToolType.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // Enable opening of drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Add drawer listeners
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        // Set up tabs and title
        if (savedInstanceState == null) {
            setupTabs(0);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_clamps:
                mCurrentNavPosition = 0;
                break;
            case R.id.nav_saws:
                mCurrentNavPosition = 1;
                break;
            case R.id.nav_drills:
                mCurrentNavPosition = 2;
                break;
            case R.id.nav_sanders:
                mCurrentNavPosition = 3;
                break;
            case R.id.nav_routers:
                mCurrentNavPosition = 4;
                break;
            case R.id.nav_more:
                mCurrentNavPosition = 5;
                break;
            default:
                Log.w(TAG, "Unknown drawer item selected");
                break;
        }

        menuItem.setChecked(true);
        setupTabs(mCurrentNavPosition);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentNavPosition = savedInstanceState.getInt(SELECTED_POSITION, 0);
        final Menu menu = mNavigationView.getMenu();
        final MenuItem menuItem = menu.getItem(mCurrentNavPosition);
        menuItem.setChecked(true);
        setupTabs(mCurrentNavPosition);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_POSITION, mCurrentNavPosition);
    }

    private void setupTabs(int position) {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        final ToolPagerAdapter toolPagerAdapter = new ToolPagerAdapter(getSupportFragmentManager(), getResources(), mToolTypes[position]);
        tabLayout.removeAllTabs();
        tabLayout.setTabsFromPagerAdapter(toolPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(toolPagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
