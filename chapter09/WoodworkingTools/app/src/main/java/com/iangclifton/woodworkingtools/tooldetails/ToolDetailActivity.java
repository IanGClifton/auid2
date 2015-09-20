package com.iangclifton.woodworkingtools.tooldetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.iangclifton.woodworkingtools.CaptionedImageView;
import com.iangclifton.woodworkingtools.R;
import com.iangclifton.woodworkingtools.Tool;

public class ToolDetailActivity extends AppCompatActivity {

    private static final String EXTRA_TOOL = "com.iangclifton.woodworkingtools.TOOL";

    public static void startActivity(Activity activity, Tool tool, Bundle activityOptions) {
        final Intent intent = new Intent(activity, ToolDetailActivity.class);
        intent.putExtra(EXTRA_TOOL, tool);
        ActivityCompat.startActivity(activity, intent, activityOptions);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Tool tool = getIntent().getParcelableExtra(EXTRA_TOOL);
        if (tool == null) {
            throw new IllegalStateException("Tool not available as extra; use startActivity when creating an activity instance");
        }

        final CaptionedImageView captionedImageView = (CaptionedImageView) findViewById(R.id.hero_image);
        captionedImageView.getImageView().setSquare(false);
        captionedImageView.getTextView().setText(tool.getName());
        captionedImageView.setImageResource(tool.getImageResourceId());

        findAndSetTextView(R.id.price, tool.getPrice());
        findAndSetTextView(R.id.detail_0, tool.getDetails()[0]);
        findAndSetTextView(R.id.detail_1, tool.getDetails()[1]);
        findAndSetTextView(R.id.detail_2, tool.getDetails()[2]);
        findAndSetTextView(R.id.description, tool.getDescription());
    }

    private void findAndSetTextView(int id, String text) {
        final TextView textView = (TextView) findViewById(id);
        textView.setText(text);
    }
}
