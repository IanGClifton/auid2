package com.auidbook.viewholder;

/**
 * POJO as a dummy list item.
 *
 * @author Ian G. Clifton
 */
public class ListItem {

    private final int mColor;
    private final String mTitle;
    private final String mSubtitle;
    private final String mCount;

    public ListItem(int color, String title, String subtitle, String count) {
        mColor = color;
        mTitle = title;
        mSubtitle = subtitle;
        mCount = count;
    }

    public int getColor() {
        return mColor;
    }

    public String getCount() {
        return mCount;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getTitle() {
        return mTitle;
    }
}
