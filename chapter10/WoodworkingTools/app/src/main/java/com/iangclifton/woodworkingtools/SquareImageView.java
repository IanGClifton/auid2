package com.iangclifton.woodworkingtools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * ImageView that forces a 1:1 aspect ratio based on width.
 *
 * @author Ian G. Clifton
 */
public class SquareImageView extends ImageView {

    private boolean mSquare = true;

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Enable or disable displaying as a square image
     *
     * @param square boolean true to make the image square
     */
    public void setSquare(boolean square) {
        if (square != mSquare) {
            mSquare = square;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mSquare) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
    }
}
