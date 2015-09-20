package com.iangclifton.woodworkingtools.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.WindowManager;

import com.iangclifton.woodworkingtools.R;

/**
 * Utility methods for working with Bitmap objects and resource IDs.
 *
 * @author Ian G. Clifton
 */
public class BitmapUtils {

    private static final int THUMBNAIL_SIZE_336 = 336;
    private static final int THUMBNAIL_SIZE_468 = 468;

    private static final BitmapCache BITMAP_CACHE = new BitmapCache();

    public synchronized static void cacheBitmap(@NonNull String key, @NonNull Bitmap bitmap) {
        BITMAP_CACHE.put(key, bitmap);
    }

    public synchronized static Bitmap getBitmap(@NonNull String key) {
        return BITMAP_CACHE.get(key);
    }

    public synchronized static Bitmap getBitmap(@NonNull Resources res, @DrawableRes int resId) {
        String key = String.valueOf(resId);
        Bitmap bitmap = BITMAP_CACHE.get(key);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(res, resId);
            BITMAP_CACHE.put(key, bitmap);
        }
        return bitmap;
    }

    public static int getScreenWidth(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    /**
     * Returns a resource ID to a smaller version of the drawable, when possible.
     *
     * This is intended just for the hero images. If a smaller size of the resource ID cannot
     * be found, the original resource ID is returned.
     *
     * @param resourceId int drawable resource ID to look for
     * @param desiredSize int desired size in pixels of the drawable
     * @return int drawable resource ID to use
     */
    @DrawableRes
    public static int getPresizedImage(@DrawableRes int resourceId, int desiredSize) {
        switch (resourceId) {
            case R.drawable.hero_image_clamps_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_clamps_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_clamps_468;
                }
                break;
            case R.drawable.hero_image_saw_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_saw_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_saw_468;
                }
                break;
            case R.drawable.hero_image_drill_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_drill_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_drill_468;
                }
                break;
            case R.drawable.hero_image_sander_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_sander_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_sander_468;
                }
                break;
            case R.drawable.hero_image_router_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_router_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_router_468;
                }
                break;
            case R.drawable.hero_image_lathe_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_lathe_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_lathe_468;
                }
                break;
            case R.drawable.hero_image_more_1080:
                if (desiredSize <= THUMBNAIL_SIZE_336) {
                    return R.drawable.hero_image_more_336;
                } else if (desiredSize <= THUMBNAIL_SIZE_468) {
                    return R.drawable.hero_image_more_468;
                }
                break;
        }

        return resourceId;
    }

    public static Bitmap getSizedBitmap(@NonNull Resources res, @DrawableRes int resId, int desiredWidth) {
        // Load just the size of the image
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Options now has the bounds; prepare it for getting the actual image
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;

        if (options.outWidth > desiredWidth) {
            final int halfWidth = options.outWidth / 2;

            while (halfWidth / options.inSampleSize > desiredWidth) {
                options.inSampleSize *= 2;
            }
        }

        return BitmapFactory.decodeResource(res, resId, options);
    }
}
