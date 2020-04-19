package com.example.myfullspacedemo;

import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyFullSpace extends BitmapTransformation {
    private static final String ID="com.example.myfullspacedemo.MyFullSpace";
    private static final byte[] ID_BYTES=ID.getBytes(CHARSET);
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        if (toTransform.getWidth()==outWidth&&toTransform.getHeight()==outHeight){
            return toTransform;
        }
        return Bitmap.createScaledBitmap(toTransform,outWidth,outHeight,true);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof MyFullSpace;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
