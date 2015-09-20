package com.auidbook.overdrawexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String[] SAMPLE_ITEMS = {
            "You don't want",
            "To work harder than necessary",
            "So don't make the device",
            "Fill pixels again",
            "And again",
            "And again",
            "Take the time",
            "To increase efficiency",
            "And make the app better"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SAMPLE_ITEMS));
    }


}
