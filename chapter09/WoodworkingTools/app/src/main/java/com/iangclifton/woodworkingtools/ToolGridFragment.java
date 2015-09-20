package com.iangclifton.woodworkingtools;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.iangclifton.woodworkingtools.toollist.ToolListActivity;


/**
 * Fragment displaying a GridView of tool types.
 *
 * @author Ian G. Clifton
 */
public class ToolGridFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ToolGridAdapter mToolGridAdapter;

    public ToolGridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tool_grid, container, false);
        final GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        mToolGridAdapter = new ToolGridAdapter(getActivity());
        gridView.setAdapter(mToolGridAdapter);
        gridView.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final CaptionedImageView captionedImageView = (CaptionedImageView) view;
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                new Pair<View, String>(captionedImageView.getImageView(), getString(R.string.transition_image_view)),
                new Pair<View, String>(captionedImageView.getTextView(), getString(R.string.transition_text_view))
        );
        ToolListActivity.startActivity(getActivity(), mToolGridAdapter.getItem(position), activityOptions.toBundle());

    }
}
