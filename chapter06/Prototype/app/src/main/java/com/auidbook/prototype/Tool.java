package com.auidbook.prototype;

import android.os.Parcel;
import android.os.Parcelable;

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

    public Tool(String name, String price, String[] details, String description) {
        mName = name;
        mPrice = price;
        mDetails = new String[DETAILS_COUNT];
        if (details != null) {
            for (int i = 0; i < details.length; i++) {
                mDetails[i] = details[i];
            }
        }
        mDescription = description;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mPrice);
        dest.writeStringArray(this.mDetails);
        dest.writeString(this.mDescription);
    }

    private Tool(Parcel in) {
        this.mName = in.readString();
        this.mPrice = in.readString();
        this.mDetails = in.createStringArray();
        this.mDescription = in.readString();
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