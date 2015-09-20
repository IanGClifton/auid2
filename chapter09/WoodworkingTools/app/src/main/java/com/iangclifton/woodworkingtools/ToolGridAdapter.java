package com.iangclifton.woodworkingtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Adapter for a GridView showing the ToolTypes.
 *
 * @author Ian G. Clifton
 */
public class ToolGridAdapter extends BaseAdapter {

    private final ToolType[] mToolTypes = ToolType.values();
    private final Context mContext;

    public ToolGridAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mToolTypes.length;
    }

    @Override
    public ToolType getItem(int position) {
        return mToolTypes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CaptionedImageView captionedImageView;
        if (convertView == null) {
            captionedImageView = new CaptionedImageView(mContext);
        } else {
            captionedImageView = (CaptionedImageView) convertView;
        }

        final ToolType toolType = mToolTypes[position];
        captionedImageView.setImageResource(toolType.getToolImageResourceId());
        captionedImageView.getTextView().setText(toolType.getToolNameResourceId());

        return captionedImageView;
    }
}
