package com.auidbook.porterduffview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

/**
 * View that can display two images composited together based on a {@link PorterDuffXfermode}.
 *
 * Use the {@link #setPorterDuffMode(android.graphics.PorterDuff.Mode)} to change the
 * {@link PorterDuff.Mode} at runtime.
 *
 * This View uses R.drawable.shape1 and R.drawable.shape2 for the compositing, so you can replace
 * those with your own assets to see how other images are affected by the various compositing modes.
 *
 * @author Ian G. Clifton
 */
public class PorterDuffView extends View {

    /**
     * The width used for measuring when a bitmap has not been generated
     */
    private int mDefaultBitmapWidth;

    /**
     * The height used for measuring when a bitmap has not been generated
     */
    private int mDefaultBitmapHeight;

    /**
     * The Paint used to draw everything
     */
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /**
     * The Bitmap containing the two images blended together
     */
    private Bitmap mBitmap;

    /**
     * PorterDuff Mode used to generate the Xfermode
     */
    private PorterDuff.Mode mPorterDuffMode = PorterDuff.Mode.CLEAR;

    /**
     * The Xfermode to combine the images with
     */
    private Xfermode mXfermode = new PorterDuffXfermode(mPorterDuffMode);

    public PorterDuffView(Context context) {
        super(context);
        initDefaultBitmapDimens();
    }

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDefaultBitmapDimens();
    }

    public PorterDuffView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultBitmapDimens();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PorterDuffView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initDefaultBitmapDimens();
    }

    /**
     * Sets the new PorterDuff.Mode, removes the existing Bitmap and invalidates the view
     *
     * @param mode PorterDuff.Mode to use
     */
    public void setPorterDuffMode(PorterDuff.Mode mode) {
        if (mode == mPorterDuffMode) {
            // No change
            return;
        }
        mPorterDuffMode = mode;
        mXfermode = new PorterDuffXfermode(mode);
        mBitmap = null;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (mBitmap == null) {
            createBitmap();
        }
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            mBitmap = null;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // Calculate the width
        int width;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            width = specSize;
        } else {
            width = getPaddingLeft() + getPaddingRight() + mDefaultBitmapWidth;
            if (specMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, specSize);
            }
        }

        // Calculate the height
        int height;
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            height = specSize;
        } else {
            height = getPaddingTop() + getPaddingBottom() + mDefaultBitmapHeight;
            if (specMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, specSize);
            }
        }

        // Set the calculated dimensions
        setMeasuredDimension(width, height);
    }

    /**
     * Creates mBitmap using the set XferMode
     */
    private void createBitmap() {

        // Prepare the Bitmap
        final int width = getWidth();
        final int height = getHeight();
        final Rect rect = new Rect();
        final int minDimen = Math.min(width, height);
        rect.right = minDimen;
        rect.bottom = minDimen;
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas c = new Canvas(mBitmap);

        // Create the destination Bitmap and paint it
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.shape1);
        c.drawBitmap(b, null, rect, mPaint);

        // Create the source Bitmap, set XferMode, and paint
        b = BitmapFactory.decodeResource(getResources(), R.drawable.shape2);
        mPaint.setXfermode(mXfermode);
        c.drawBitmap(b, null, rect, mPaint);

        // Remove the XferMode
        mPaint.setXfermode(null);
    }

    private void initDefaultBitmapDimens() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.shape1, options);

        mDefaultBitmapWidth = options.outWidth;
        mDefaultBitmapHeight = options.outHeight;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof PorterDuffSavedState)) {
            // Not our saved state
            super.onRestoreInstanceState(state);
            return;
        }

        final PorterDuffSavedState ourState = (PorterDuffSavedState) state;
        super.onRestoreInstanceState(ourState.getSuperState());
        setPorterDuffMode(ourState.mode);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        final PorterDuffSavedState ourState = new PorterDuffSavedState(superState);
        ourState.mode = mPorterDuffMode;
        return ourState;
    }

    private static class PorterDuffSavedState extends BaseSavedState {

        public PorterDuff.Mode mode;

        public PorterDuffSavedState(Parcel source) {
            super(source);
            mode = (PorterDuff.Mode) source.readSerializable();
        }

        public PorterDuffSavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeSerializable(mode);
        }
    }
}
