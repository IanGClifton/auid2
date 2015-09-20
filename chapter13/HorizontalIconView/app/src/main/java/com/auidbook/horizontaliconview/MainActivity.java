package com.auidbook.horizontaliconview;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a List of Drawables
        final Resources res = getResources();
        final List<Drawable> list = new ArrayList<>();
        list.add(res.getDrawable(R.drawable.a));
        list.add(res.getDrawable(R.drawable.b));
        list.add(res.getDrawable(R.drawable.c));
        list.add(res.getDrawable(R.drawable.d));
        list.add(res.getDrawable(R.drawable.e));
        list.add(res.getDrawable(R.drawable.f));
        list.add(res.getDrawable(R.drawable.g));
        list.add(res.getDrawable(R.drawable.h));
        list.add(res.getDrawable(R.drawable.i));
        list.add(res.getDrawable(R.drawable.j));
        list.add(res.getDrawable(R.drawable.k));
        list.add(res.getDrawable(R.drawable.l));
        list.add(res.getDrawable(R.drawable.m));
        list.add(res.getDrawable(R.drawable.n));
        list.add(res.getDrawable(R.drawable.o));
        list.add(res.getDrawable(R.drawable.p));
        list.add(res.getDrawable(R.drawable.q));
        list.add(res.getDrawable(R.drawable.r));
        list.add(res.getDrawable(R.drawable.s));
        list.add(res.getDrawable(R.drawable.t));
        list.add(res.getDrawable(R.drawable.u));
        list.add(res.getDrawable(R.drawable.v));
        list.add(res.getDrawable(R.drawable.w));
        list.add(res.getDrawable(R.drawable.x));
        list.add(res.getDrawable(R.drawable.y));
        list.add(res.getDrawable(R.drawable.z));

        final HorizontalIconView view = (HorizontalIconView) findViewById(R.id.horizontal_icon_view);
        view.setDrawables(list);
    }


}
