package com.example.myfullspacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;

public class MainActivity extends AppCompatActivity {
private ImageView iv_mask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_mask=findViewById(R.id.iv_mask);
        Glide.with(this)
                .load("http://contentcms-bj.cdn.bcebos.com/cmspic/b40b9a70c423b6ea6ea14a474f9706c9.jpeg")
                .transform(new MultiTransformation<Bitmap>(new MyFullSpace(),new MyTextMask()))
                .into(iv_mask);
    }
}
