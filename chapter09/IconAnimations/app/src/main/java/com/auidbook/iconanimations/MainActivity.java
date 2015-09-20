package com.auidbook.iconanimations;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.icon).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ImageView imageView = (ImageView) v;
        final AnimatedVectorDrawable avd = (AnimatedVectorDrawable) imageView.getDrawable();
        avd.start();

    }
}
