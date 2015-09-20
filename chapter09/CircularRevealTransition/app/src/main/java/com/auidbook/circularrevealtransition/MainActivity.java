package com.auidbook.circularrevealtransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContainer = findViewById(R.id.container);
        findViewById(R.id.button_reveal).setOnClickListener(this);
        findViewById(R.id.button_hide).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Determine center
        final int x = (mContainer.getRight() - mContainer.getLeft()) / 2;
        final int y = (mContainer.getBottom() - mContainer.getTop()) / 2;

        // Determine radius sizes
        final int containerWidth = mContainer.getWidth() / 2;
        final int containerHeight = mContainer.getHeight() / 2;
        final int maxRadius = (int) Math.sqrt((containerWidth * containerWidth) + (containerHeight * containerHeight));
        final int startingRadius;
        final int finalRadius;
        if (v.getId() == R.id.button_reveal) {
            startingRadius = 0;
            finalRadius = maxRadius;
            mContainer.setVisibility(View.VISIBLE);
        } else {
            startingRadius = maxRadius;
            finalRadius = 0;
        }

        // Animate
        final Animator animator = ViewAnimationUtils.createCircularReveal(mContainer, x, y, startingRadius, finalRadius);
        if (v.getId() == R.id.button_hide) {
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mContainer.setVisibility(View.INVISIBLE);
                }
            });
        }
        animator.start();
    }
}
