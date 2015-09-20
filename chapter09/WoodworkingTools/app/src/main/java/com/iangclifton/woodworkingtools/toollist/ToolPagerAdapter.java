package com.iangclifton.woodworkingtools.toollist;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iangclifton.woodworkingtools.R;
import com.iangclifton.woodworkingtools.ToolType;

import java.util.ArrayList;
import java.util.List;

/**
 * FragmentPagerAdapter for Tools.
 *
 * @author Ian G. Clifton
 */
public class ToolPagerAdapter extends FragmentPagerAdapter {

    private final CharSequence[] mTitles;
    private final List<ToolTab> mToolTabs;
    private final ToolType mToolType;
    private final ToolType[] mToolTypes = ToolType.values();

    public ToolPagerAdapter(FragmentManager fm, Resources res, ToolType toolType) {
        super(fm);
        mToolType = toolType;
        mToolTabs = getToolTabs(toolType);
        mTitles = new CharSequence[mToolTabs.size()];
        for (int i = 0; i < mTitles.length; i++) {
            mTitles[i] = res.getString(mToolTabs.get(i).getStringResourceId());
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ToolAboutFragment.newInstance(mToolType);
        }
        return ToolListFragment.newInstance(mToolTabs.get(position));
    }

    @Override
    public int getCount() {
        return mToolTabs.size();
    }

    @Override
    public long getItemId(int position) {
        for (int i = 0; i < mToolTypes.length; i++) {
            if (mToolTypes[i] == mToolType) {
                return (i * 10) + position;
            }
        }
        throw new IllegalArgumentException("Invalid position (" + position + ") or ToolType (" + mToolType + ")");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    private List<ToolTab> getToolTabs(ToolType toolType) {
        int i = 0;
        final List<ToolTab> toolTabs = new ArrayList<>();
        toolTabs.add(new ToolTab(i++, toolType, R.string.about));
        switch (toolType) {
            case CLAMPS:
                toolTabs.add(new ToolTab(i++, toolType, R.string.spring_clamps));
                toolTabs.add(new ToolTab(i++, toolType, R.string.parallel_clamps));
                toolTabs.add(new ToolTab(i++, toolType, R.string.pipe_clamps));
                toolTabs.add(new ToolTab(i++, toolType, R.string.bar_clamps));
                toolTabs.add(new ToolTab(i++, toolType, R.string.toggle_clamps));
                break;
            case SAWS:
                toolTabs.add(new ToolTab(i++, toolType, R.string.table_saws));
                toolTabs.add(new ToolTab(i++, toolType, R.string.band_saws));
                toolTabs.add(new ToolTab(i++, toolType, R.string.circular_saws));
                toolTabs.add(new ToolTab(i++, toolType, R.string.jig_saws));
                break;
            case DRILLS:
                toolTabs.add(new ToolTab(i++, toolType, R.string.drill_presses));
                toolTabs.add(new ToolTab(i++, toolType, R.string.handheld));
                break;
            case SANDERS:
                toolTabs.add(new ToolTab(i++, toolType, R.string.stationary));
                toolTabs.add(new ToolTab(i++, toolType, R.string.handheld));
                break;
            case ROUTERS:
                toolTabs.add(new ToolTab(i++, toolType, R.string.routers));
                break;
            case LATHES:
                toolTabs.add(new ToolTab(i++, toolType, R.string.lathes));
                break;
            case MORE:
//                toolTabs.add(new ToolTab(i++, toolType, R.string.more));
                break;
        }
        return toolTabs;
    }
}
