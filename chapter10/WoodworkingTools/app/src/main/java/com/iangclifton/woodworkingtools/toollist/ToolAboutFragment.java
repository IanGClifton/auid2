package com.iangclifton.woodworkingtools.toollist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iangclifton.woodworkingtools.CaptionedImageView;
import com.iangclifton.woodworkingtools.R;
import com.iangclifton.woodworkingtools.ToolType;

/**
 * Fragment that shows the
 */
public class ToolAboutFragment extends Fragment {

    private static final String ARG_TOOL_TYPE = "toolType";

    private ToolType mToolType;

    public static ToolAboutFragment newInstance(ToolType toolType) {
        final ToolAboutFragment fragment = new ToolAboutFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_TOOL_TYPE, toolType.name());
        fragment.setArguments(args);
        return fragment;
    }

    public ToolAboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args == null) {
            throw new IllegalStateException("No arguments set; use newInstance when constructing!");
        }
        mToolType = ToolType.valueOf(args.getString(ARG_TOOL_TYPE));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_tool_about, container, false);

        final CaptionedImageView captionedImageView = (CaptionedImageView) rootView.findViewById(R.id.hero_image);
        captionedImageView.getImageView().setSquare(false);
        captionedImageView.getTextView().setText(mToolType.getToolNameResourceId());
        captionedImageView.setImageResource(mToolType.getToolImageResourceId());
        final TextView textView = (TextView) rootView.findViewById(R.id.description);
        textView.setText(mToolType.getToolDescriptionResourceId());

        return rootView;
    }
}
