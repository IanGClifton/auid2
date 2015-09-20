package com.auidbook.woodworkingtools.toollist;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.auidbook.woodworkingtools.ToolType;

/**
 * Represents a tab for a particular ToolType.
 *
 * @author Ian G. Clifton
 */
public class ToolTab implements Parcelable {

    private final int mStringResourceId;
    private final int mTabId;
    private final ToolType mToolType;

    public ToolTab(int tabId, @NonNull ToolType toolType, @StringRes int stringResourceId) {
        mTabId = tabId;
        mToolType = toolType;
        mStringResourceId = stringResourceId;
    }

    public int getStringResourceId() {
        return mStringResourceId;
    }

    public int getTabId() {
        return mTabId;
    }

    public ToolType getToolType() {
        return mToolType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStringResourceId);
        dest.writeInt(mTabId);
        dest.writeSerializable(mToolType);
    }

    private ToolTab(Parcel in) {
        mStringResourceId = in.readInt();
        mTabId = in.readInt();
        mToolType = (ToolType) in.readSerializable();
    }

    public static final Parcelable.Creator<ToolTab> CREATOR = new Parcelable.Creator<ToolTab>() {
        public ToolTab createFromParcel(Parcel source) {
            return new ToolTab(source);
        }

        public ToolTab[] newArray(int size) {
            return new ToolTab[size];
        }
    };
}