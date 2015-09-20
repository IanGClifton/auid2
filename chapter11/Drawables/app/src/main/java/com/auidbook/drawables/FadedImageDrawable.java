package com.auidbook.drawables;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * Created by ian on 7/16/15.
 */
public class FadedImageDrawable extends Drawable {

    private Bitmap mBitmap;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    public FadedImageDrawable(Bitmap bitmap) {
        setBitmap(bitmap);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, null, getBounds(), mPaint);
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        int oldAlpha = mPaint.getAlpha();
        if (alpha != oldAlpha) {
            mPaint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    /**
     * Sets the {@link Bitmap} to draw and invalidates itself
     *
     * @param bitmap Bitmap to draw with rounded corners
     */
    public void setBitmap(@NonNull Bitmap bitmap) {
        mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(mBitmap);
        final LinearGradient linearGradient = new LinearGradient(0, 0, 0, bitmap.getHeight(), 0xFF000000, 0x00000000, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
        canvas.drawRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), mPaint);
        mPaint.setShader(null);
        mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        mPaint.setXfermode(null);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
        invalidateSelf();
    }
}
