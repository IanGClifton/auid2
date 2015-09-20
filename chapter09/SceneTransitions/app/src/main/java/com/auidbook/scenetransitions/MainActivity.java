package com.auidbook.scenetransitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Scene mCurrentScene;
    private Scene mScene1;
    private Scene mScene2;
    private ViewGroup mSceneRoot;
    private Transition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, this);
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene2, this);

        mTransition = new ChangeBounds();
        mTransition.setDuration(DateUtils.SECOND_IN_MILLIS);
        mTransition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.go(mScene1);
        mCurrentScene = mScene1;

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mCurrentScene == mScene1) {
            TransitionManager.go(mScene2, mTransition);
            mCurrentScene = mScene2;
        } else {
            TransitionManager.go(mScene1, mTransition);
            mCurrentScene = mScene1;
        }
    }
}
