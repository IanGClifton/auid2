package com.auidbook.keyframedemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.button).setOnClickListener(this);
    }


    @Override
    public void onClick(final View button) {
        button.setEnabled(false);
        View icon = findViewById(R.id.icon);

        Keyframe keyframe1 = Keyframe.ofFloat(0f, 0f);
        Keyframe keyframe2 = Keyframe.ofFloat(.4f, 90f);
        Keyframe keyframe3 = Keyframe.ofFloat(.6f, 90f);
        Keyframe keyframe4 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe1, keyframe2, keyframe3, keyframe4);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(icon, propertyValuesHolder);
        rotationAnim.setDuration(5000);
        rotationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                button.setEnabled(true);
            }
        });
        rotationAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnim.start();
    }
}
