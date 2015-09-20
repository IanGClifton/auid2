package com.iangclifton.woodworkingtools.toollist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iangclifton.woodworkingtools.R;
import com.iangclifton.woodworkingtools.Tool;

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

        // Set thumbnail
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
        imageView.setImageResource(tool.getThumbnailResourceId());

        return convertView;
    }

}