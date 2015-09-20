package com.auidbook.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * ArrayAdapter for a list of Tools.
 *
 * @author Ian G. Clifton
 */
public class ToolArrayAdapter extends ArrayAdapter<Tool> {

    private final LayoutInflater mLayoutInflater;

    public ToolArrayAdapter(Context context, List<Tool> objects) {
        super(context, -1, objects);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_tool, parent, false);
        }
        final Tool tool = getItem(position);

        // Set TextViews
        TextView textView = (TextView) convertView.findViewById(R.id.price);
        textView.setText(tool.getPrice());
        textView = (TextView) convertView.findViewById(R.id.name);
        textView.setText(tool.getName());
        textView = (TextView) convertView.findViewById(R.id.meta);
        textView.setText(tool.getDetails()[0]);

        // Set color for thumbnail
        convertView.findViewById(R.id.thumbnail).setBackgroundColor(getThumbnailColor(tool.getName().hashCode()));

        return convertView;
    }

    private int getThumbnailColor(int key) {
        switch (Math.abs(key) % 3) {
            case 0:
                return 0xff777777;
            case 1:
                return 0xff999999;
            case 2:
                return 0xffbbbbbb;
        }

        return 0;
    }
}