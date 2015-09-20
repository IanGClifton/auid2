package com.auidbook.prototype;

import android.support.annotation.StringRes;

/**
 * Enum of different types of tools such as saws and drills.
 *
 * @author Ian G. Clifton
 */
public enum ToolType {
    CLAMPS(R.string.clamps, R.string.clamps_description),
    SAWS(R.string.saws, R.string.saws_description),
    DRILLS(R.string.drills, R.string.drills_description),
    SANDERS(R.string.sanders, R.string.sanders_description),
    ROUTERS(R.string.routers, R.string.routers_description),
    MORE(R.string.more, R.string.more_description),
    ;

    private final int mToolNameResourceId;
    private final int mToolDescriptionResourceId;

    private ToolType(@StringRes int toolName, @StringRes int toolDescription) {
        mToolNameResourceId = toolName;
        mToolDescriptionResourceId = toolDescription;
    }

    @StringRes
    public int getToolDescriptionResourceId() {
        return mToolDescriptionResourceId;
    }

    @StringRes
    public int getToolNameResourceId() {
        return mToolNameResourceId;
    }
}