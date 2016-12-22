package com.auidbook.animationexamples;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ian on 6/18/15.
 */
public class InterpolatorAdapter extends ArrayAdapter<TimeInterpolator> {

    private static final TimeInterpolator[] INTERPOLATORS = {
            new AccelerateDecelerateInterpolator(),
            new AccelerateInterpolator(),
            new AnticipateInterpolator(),
            new AnticipateOvershootInterpolator(),
            new BounceInterpolator(),
            new CycleInterpolator(5),
            new DecelerateInterpolator(),
            new FastOutLinearInInterpolator(),
            new FastOutSlowInInterpolator(),
            new LinearInterpolator(),
            new LinearOutSlowInInterpolator(),
            new OvershootInterpolator(),
            new PathInterpolator(.4f, 0, 1, 1),
    };

    public InterpolatorAdapter(Context context) {
        super(context, android.R.layout.simple_spinner_item, INTERPOLATORS);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        textView.setText(getItem(position).getClass().getSimpleName());
        return textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setText(getItem(position).getClass().getSimpleName());
        return textView;
    }
}
