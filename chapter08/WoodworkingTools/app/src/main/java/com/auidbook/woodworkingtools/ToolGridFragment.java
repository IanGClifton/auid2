package com.auidbook.woodworkingtools;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.auidbook.woodworkingtools.toollist.ToolListActivity;


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
        ToolListActivity.startActivity(getActivity(), mToolGridAdapter.getItem(position));
    }
}