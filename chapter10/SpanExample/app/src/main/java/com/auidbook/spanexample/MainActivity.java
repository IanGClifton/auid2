package com.auidbook.spanexample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SpannableStringBuilder ssb = new SpannableStringBuilder();
        final int flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;
        int start;
        int end;

        // Regular text
        ssb.append("This text is normal, but ");

        // Bold text
        start = ssb.length();
        ssb.append("this text is bold");
        end = ssb.length();
        ssb.setSpan(new StyleSpan(Typeface.BOLD), start, end, flag);

        // Inline image
        ssb.append('\n');
        start = end + 1;
        ssb.append('\uFFFC'); // Unicode replacement character
        end = ssb.length();
        ssb.setSpan(new ImageSpan(this, R.mipmap.ic_launcher), start, end, flag);

        // Stretched text
        start = end;
        ssb.append("This text is wide");
        end = ssb.length();
        ssb.setSpan(new ScaleXSpan(2f), start, end, flag);

        // Assign to TextView
        final TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(ssb);
    }
}
