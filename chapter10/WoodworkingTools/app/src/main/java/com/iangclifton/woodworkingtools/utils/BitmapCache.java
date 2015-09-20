package com.iangclifton.woodworkingtools.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * LRU Cache for Bitmaps.
 *
 * @author Ian G. Clifton
 */
public class BitmapCache extends LruCache<String, Bitmap> {
    public static final String TAG = "BitmapCache";

    private static final int MAXIMUM_SIZE_IN_KB = 1024 * 16;

    public BitmapCache() {
        super(getCacheSize());
    }

    @Override
    protected int sizeOf(String key, Bitmap bitmap) {
        return bitmap.getByteCount() / 1024;
    }

    /**
     * Returns the size of the cache in kilobytes
     *
     * @return int total kilobytes to make the cache
     */
    private static int getCacheSize() {
        // Maximum KB available to the VM
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // The smaller of a tenth of the total memory or 10MB
        final int cacheSize = Math.min(maxMemory / 8, MAXIMUM_SIZE_IN_KB);
        Log.v(TAG, "BitmapCache size: " + cacheSize + "kb");
        return cacheSize;
    }
}
