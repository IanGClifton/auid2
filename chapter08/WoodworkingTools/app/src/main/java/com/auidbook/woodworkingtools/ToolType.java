package com.auidbook.woodworkingtools;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Enum of different types of tools such as saws and drills.
 *
 * @author Ian G. Clifton
 */
public enum ToolType {
    CLAMPS(R.string.clamps, R.string.clamps_description, R.drawable.hero_image_clamps),
    SAWS(R.string.saws, R.string.saws_description, R.drawable.hero_image_saw),
    DRILLS(R.string.drills, R.string.drills_description, R.drawable.hero_image_drill),
    SANDERS(R.string.sanders, R.string.sanders_description, R.drawable.hero_image_sander),
    ROUTERS(R.string.routers, R.string.routers_description, R.drawable.hero_image_router),
    LATHES(R.string.lathes, R.string.lathes_description, R.drawable.hero_image_lathe),
    MORE(R.string.more, R.string.more_description, R.drawable.hero_image_more),
    ;

    private final int mToolNameResourceId;
    private final int mToolDescriptionResourceId;
    private final int mToolImageResourceId;

    private ToolType(@StringRes int toolName, @StringRes int toolDescription, @DrawableRes int toolImage) {
        mToolNameResourceId = toolName;
        mToolDescriptionResourceId = toolDescription;
        mToolImageResourceId = toolImage;
    }

    @StringRes
    public int getToolDescriptionResourceId() {
        return mToolDescriptionResourceId;
    }

    @StringRes
    public int getToolNameResourceId() {
        return mToolNameResourceId;
    }

    @DrawableRes
    public int getToolImageResourceId() {
        return mToolImageResourceId;
    }
}