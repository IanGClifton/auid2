package com.auidbook.drawables;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * Drawable that poorly handles text.
 *
 * @author Ian G. Clifton
 */
public class SimpleTextDrawable extends Drawable {

    private static final int TEXT_COLOR = 0xFF311B92;

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final String mText;

    public SimpleTextDrawable(String text) {
        mText = text;
        mPaint.setColor(TEXT_COLOR);
        mPaint.setTextSize(100);
    }

    @Override
    public int getIntrinsicHeight() {
        return (int) mPaint.getTextSize();
    }

    @Override
    public int getIntrinsicWidth() {
        return (int) mPaint.measureText(mText);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(mText, 0, mPaint.getTextSize(), mPaint);
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

}
