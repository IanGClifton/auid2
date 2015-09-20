package com.auidbook.drawables;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/**
 * Drawable that handles multiple lines of text.
 *
 * @author Ian G. Clifton
 */
public class BetterTextDrawable extends Drawable {

    private static final int TEXT_COLOR = 0xFF311B92;

    private final TextPaint mPaint = new TextPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
    private final String mText;
    private StaticLayout mStaticLayout;

    public BetterTextDrawable(String text) {
        mText = text;
        mPaint.setColor(TEXT_COLOR);
        mPaint.setTextSize(100);
        mStaticLayout = new StaticLayout(mText, mPaint, (int) mPaint.measureText(mText), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
    }

    @Override
    public int getIntrinsicHeight() {
        return mStaticLayout.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mStaticLayout.getWidth();
    }

    @Override
    public void draw(Canvas canvas) {
        mStaticLayout.draw(canvas);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mStaticLayout = new StaticLayout(mText, mPaint, bounds.width(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
    }
}
