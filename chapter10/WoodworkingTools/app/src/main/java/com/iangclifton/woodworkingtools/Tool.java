package com.iangclifton.woodworkingtools;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

/**
 * Simple representation of some kind of tool
 *
 * @author Ian G. Clifton
 */
public class Tool implements Parcelable {

    private static final int DETAILS_COUNT = 3;

    private final String mName;
    private final String mPrice;
    private final String[] mDetails;
    private final String mDescription;
    private final int mImageResourceId;
    private final int mThumbnailResourceId;

    public Tool(String name, String price, String[] details, String description, @DrawableRes int imageResourceId, @DrawableRes int thumbnailResourceId) {
        mName = name;
        mPrice = price;
        mDetails = new String[DETAILS_COUNT];
        if (details != null) {
            System.arraycopy(details, 0, mDetails, 0, details.length);
        }
        mDescription = description;
        mImageResourceId = imageResourceId;
        mThumbnailResourceId = thumbnailResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String[] getDetails() {
        return mDetails;
    }

    public String getName() {
        return mName;
    }

    public String getPrice() {
        return mPrice;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getThumbnailResourceId() {
        return mThumbnailResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mPrice);
        dest.writeStringArray(mDetails);
        dest.writeString(mDescription);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mThumbnailResourceId);
    }

    private Tool(Parcel in) {
        mName = in.readString();
        mPrice = in.readString();
        mDetails = in.createStringArray();
        mDescription = in.readString();
        mImageResourceId = in.readInt();
        mThumbnailResourceId = in.readInt();
    }

    public static final Parcelable.Creator<Tool> CREATOR = new Parcelable.Creator<Tool>() {
        public Tool createFromParcel(Parcel source) {
            return new Tool(source);
        }

        public Tool[] newArray(int size) {
            return new Tool[size];
        }
    };
}