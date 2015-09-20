package com.auidbook.drawables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final View view = findViewById(R.id.view);
        final ImageView imageView = (ImageView) findViewById(R.id.image);

        // SimpleTextDrawable
//        view.setBackgroundDrawable(new SimpleTextDrawable("Hello World!"));

        // BetterTextDrawable
//        view.setBackgroundDrawable(new BetterTextDrawable("This is a really long string of text that will require multiple lines."));

        // SimpleImageDrawable
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        final SimpleImageDrawable simpleImageDrawable = new SimpleImageDrawable(bitmap);
//        view.setBackgroundDrawable(simpleImageDrawable);


        // LightingColorFilter example
        //                AARRGGBB
        final int mul = 0xFF00FF00;
        final int add = 0x000000BB;
        final ColorFilter lightingColorFilter = new LightingColorFilter(mul, add);
//        simpleImageDrawable.setColorFilter(lightingColorFilter);

        // ColorMatrixColorFilter example
        final ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        final ColorMatrix colorScale = new ColorMatrix();
        colorScale.setScale(2f, .68f, .26f, 1f); // Orange
        colorMatrix.postConcat(colorScale);
//        simpleImageDrawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        // RoundedImageDrawable
        final Bitmap largeBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.giwajip);
        final RoundedImageDrawable roundedImageDrawable = new RoundedImageDrawable(largeBitmap, 200);
//        imageView.setImageDrawable(roundedImageDrawable);

        // FadedImageDrawable
        final FadedImageDrawable fadedImageDrawable = new FadedImageDrawable(largeBitmap);
        imageView.setImageDrawable(fadedImageDrawable);
    }

}
