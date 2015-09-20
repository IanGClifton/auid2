package com.iangclifton.woodworkingtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.iangclifton.woodworkingtools.utils.BitmapUtils;

/**
 * Adapter for a GridView showing the ToolTypes.
 *
 * @author Ian G. Clifton
 */
public class ToolGridAdapter extends BaseAdapter {

    private final ToolType[] mToolTypes = ToolType.values();
    private final Context mContext;
    private final int mThumbnailSize;

    public ToolGridAdapter(Context context) {
        mContext = context;
        int screenWidth = BitmapUtils.getScreenWidth(context);
        int spacing = context.getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int padding = context.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin) * 2;
        mThumbnailSize = (screenWidth - spacing - padding) / 2;
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
        final int imageResourceId = BitmapUtils.getPresizedImage(toolType.getToolImageResourceId(), mThumbnailSize);
        captionedImageView.getTextView().setText(toolType.getToolNameResourceId());
        captionedImageView.setImageResource(imageResourceId);
        return captionedImageView;
    }
}
