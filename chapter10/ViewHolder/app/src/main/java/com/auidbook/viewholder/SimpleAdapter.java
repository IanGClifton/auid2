package com.auidbook.viewholder;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * An Adapter that is inefficient from the findViewById calls.
 *
 * @author Ian G. Clifton
 */
public class SimpleAdapter extends BaseAdapter {

    private final List<ListItem> mData = new ArrayList<>();
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SimpleAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        // Create dummy data
        mData.add(new ListItem(0xFFE91E63, "Pink", "Named after a flower", "340"));
        mData.add(new ListItem(0xFF9C27B0, "Purple", "The rare color of royalty", "291"));
        mData.add(new ListItem(0xFF3F51B5, "Indigo", "Not to be confused with Inigo Montoya", "231"));
        mData.add(new ListItem(0xFF2196F3, "Blue", "Like the ocean, the sky, and half of all app icons", "207"));
        mData.add(new ListItem(0xFF607D8B, "Blue Gray", "A cool gray", "200"));
        mData.add(new ListItem(0xFF4CAF50, "Green", "The color we can most easily discern", "122"));
        mData.add(new ListItem(0xFFCDDC39, "Lime", "Refreshing with the right drink", "66"));
        mData.add(new ListItem(0xFFFFEB3B, "Yellow", "Bright, happy, vibrant", "54"));
        mData.add(new ListItem(0xFFFF9800, "Orange", "Danger or warmth or a pumpkin", "36"));
        mData.add(new ListItem(0xFF795548, "Brown", "Earthy", "16"));
        mData.add(new ListItem(0xFFF44336, "Red", "A most powerful color", "4"));
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ListItem getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        }

        ListItem listItem = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Drawable drawable = mContext.getDrawable(R.drawable.person);
        drawable.setTintMode(PorterDuff.Mode.SRC_ATOP);
        drawable.setTint(listItem.getColor());
        imageView.setImageDrawable(drawable);

        TextView textView = (TextView) convertView.findViewById(R.id.count);
        textView.setText(listItem.getCount());
        textView = (TextView) convertView.findViewById(R.id.title);
        textView.setText(listItem.getTitle());
        textView = (TextView) convertView.findViewById(R.id.subtitle);
        textView.setText(listItem.getSubtitle());

        return convertView;
    }
}
