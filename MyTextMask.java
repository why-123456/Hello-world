package com.example.myfullspacedemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyTextMask extends BitmapTransformation {
    private static final String ID="com.example.myfullspacedemo.MyTextMask";
    private static final byte[] ID_BYTES=ID.getBytes(CHARSET);
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap=pool.get(toTransform.getWidth(),toTransform.getHeight(),Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);

        Canvas canvas=new Canvas(bitmap);
        canvas.drawBitmap(toTransform,0f,0f,null);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(150f);
        paint.setColor(Color.GREEN);
        canvas.drawText("36郑悦悦",300,200,paint);
        canvas.setBitmap(null);
        return bitmap;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof MyTextMask;
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
