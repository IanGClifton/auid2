package com.iangclifton.woodworkingtools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.DrawableRes;
import android.support.v4.os.TraceCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.iangclifton.woodworkingtools.utils.BitmapUtils;


/**
 * FrameLayout that displays a square image and a caption over it.
 *
 * The text for the caption has a blurred background to make it more readable.
 *
 * @author Ian G. Clifton
 */
public class CaptionedImageView extends FrameLayout implements View.OnLayoutChangeListener {

    private Drawable mDrawable;
    private int mDrawableResourceId;
    private TextView mTextView;
    private SquareImageView mImageView;
    private int mScrimColor;

    public CaptionedImageView(Context context) {
        super(context);
        init(context);
    }

    public CaptionedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CaptionedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CaptionedImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public SquareImageView getImageView() {
        return mImageView;
    }

    public TextView getTextView() {
        return mTextView;
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (v.getVisibility() != VISIBLE) {
            return;
        }
        final int height = bottom - top;
        final int width = right - left;
        if (height == 0 || width == 0) {
            return;
        }
        updateBlur();
    }

    public void setImageResource(@DrawableRes int drawableResourceId) {
        TraceCompat.beginSection("BLUR - setImageResource");
        mDrawableResourceId = drawableResourceId;
        Bitmap bitmap = BitmapUtils.getBitmap(getResources(), mDrawableResourceId);
        mDrawable = new BitmapDrawable(getResources(), bitmap);
        mImageView.setImageDrawable(mDrawable);
        updateBlur();
        TraceCompat.endSection();
    }

    private void updateBlur() {
        if (!(mDrawable instanceof BitmapDrawable)) {
            return;
        }
        final int textViewHeight = mTextView.getHeight();
        final int imageViewHeight = mImageView.getHeight();
        if (textViewHeight == 0 || imageViewHeight == 0) {
            return;
        }

        // Get the Bitmap
        final BitmapDrawable bitmapDrawable = (BitmapDrawable) mDrawable;
        final Bitmap originalBitmap = bitmapDrawable.getBitmap();

        // Determine the size of the TextView compared to the height of the ImageView
        final float ratio = (float) textViewHeight / imageViewHeight;

        // Calculate the height as a ratio of the Bitmap
        final int height = (int) (ratio * originalBitmap.getHeight());
        final int width = originalBitmap.getWidth();
        final String blurKey = getBlurKey(width);
        Bitmap newBitmap = BitmapUtils.getBitmap(blurKey);
        if (newBitmap != null) {
            mImageView.setImageBitmap(newBitmap);
            return;
        }

        // The y position is the number of pixels height represents from the bottom of the Bitmap
        final int y = originalBitmap.getHeight() - height;

        TraceCompat.beginSection("BLUR - createBitmaps");
        final Bitmap portionToBlur = Bitmap.createBitmap(originalBitmap, 0, y, originalBitmap.getWidth(), height);
        final Bitmap blurredBitmap = Bitmap.createBitmap(portionToBlur.getWidth(), height, Bitmap.Config.ARGB_8888);
        TraceCompat.endSection();

        // Use RenderScript to blur the pixels
        TraceCompat.beginSection("BLUR - RenderScript");
        RenderScript rs = RenderScript.create(getContext());
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        TraceCompat.beginSection("BLUR - RenderScript Allocation");
        Allocation tmpIn = Allocation.createFromBitmap(rs, portionToBlur);
        // Fix internal trace that isn't ended
        TraceCompat.endSection();
        Allocation tmpOut = Allocation.createFromBitmap(rs, blurredBitmap);
        // Fix internal trace that isn't ended
        TraceCompat.endSection();
        TraceCompat.endSection();
        theIntrinsic.setRadius(25f);
        theIntrinsic.setInput(tmpIn);
        TraceCompat.beginSection("BLUR - RenderScript forEach");
        theIntrinsic.forEach(tmpOut);
        TraceCompat.endSection();
        TraceCompat.beginSection("BLUR - RenderScript copyTo");
        tmpOut.copyTo(blurredBitmap);
        TraceCompat.endSection();
        new Canvas(blurredBitmap).drawColor(mScrimColor);
        TraceCompat.endSection();

        // Create the new bitmap using the old plus the blurred portion and display it
        TraceCompat.beginSection("BLUR - Finalize image");
        newBitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888, true);
        final Canvas canvas = new Canvas(newBitmap);
        canvas.drawBitmap(blurredBitmap, 0, y, new Paint());
        BitmapUtils.cacheBitmap(blurKey, newBitmap);
        mTextView.setBackground(null);
        mImageView.setImageBitmap(newBitmap);
        TraceCompat.endSection();
    }

    private void init(Context context) {
        inflate(context, R.layout.captioned_image_view, this);
        mTextView = (TextView) findViewById(R.id.text);
        mImageView = (SquareImageView) findViewById(R.id.image);
        mScrimColor = getResources().getColor(R.color.grid_item_scrim);
        mTextView.addOnLayoutChangeListener(this);
    }

    private String getBlurKey(int width) {
        return "BLUR " + width + "x" + mDrawableResourceId;
    }
}
