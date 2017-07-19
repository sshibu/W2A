package com.example.android.w2a;

import com.microsoft.azure.mobile.MobileCenter;

import com.microsoft.azure.mobile.analytics.Analytics;

import com.microsoft.azure.mobile.crashes.Crashes;

import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;


public class W2A extends Activity
{
    // declare androidAnimation instance field with frame-by-frame animations
    AnimationDrawable androidAnimation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MobileCenter.start(getApplication(), "f730c7fa-158a-4060-8a8e-b63f0f68bda5",
                Analytics.class, Crashes.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView androidImage = (ImageView) findViewById(android);
        androidImage.setBackgroundResource(R.drawable.android_animate);
        androidAnimation = (AnimationDrawable) androidImage.getBackground();
        final Button btnAnimate = (Button) findViewById(R.id.animate);
        View.OnClickListener ocl;
        ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidAnimation.stop();
                androidAnimation.start();
            }
        };
        Analytics.trackEvent("Button clicked");
        btnAnimate.setOnClickListener(ocl);

    }
}