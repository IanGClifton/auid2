package com.auidbook.woodworkingtools.tooldetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.auidbook.woodworkingtools.CaptionedImageView;
import com.auidbook.woodworkingtools.R;
import com.auidbook.woodworkingtools.Tool;

public class ToolDetailActivity extends AppCompatActivity {

    private static final String EXTRA_TOOL = "com.auidbook.woodworkingtools.TOOL";

    public static void startActivity(Context context, Tool tool) {
        final Intent intent = new Intent(context, ToolDetailActivity.class);
        intent.putExtra(EXTRA_TOOL, tool);
        context.startActivity(intent);
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