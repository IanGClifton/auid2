package com.auidbook.porterduffview;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<PorterDuff.Mode> mAdapter;
    private PorterDuffView mPorterDuffView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get reference to the PorterDuffView
        mPorterDuffView = (PorterDuffView) findViewById(R.id.porter_duff_view);

        // Create array of PorterDuff.Modes
        final PorterDuff.Mode[] porterDuffModes = PorterDuff.Mode.values();
        mAdapter = new ArrayAdapter<PorterDuff.Mode>(this, android.R.layout.simple_spinner_item, porterDuffModes);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(mAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mPorterDuffView.setPorterDuffMode(mAdapter.getItem(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Ignored
    }
}
