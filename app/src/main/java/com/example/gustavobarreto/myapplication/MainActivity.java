package com.example.gustavobarreto.myapplication;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View rootView;
    ImageView mIcDownloadAnimator;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = View.inflate(this, R.layout.activity_main, null);
        setContentView(v);

        rootView = v.findViewById(R.id.rootView);
        mIcDownloadAnimator = v.findViewById(R.id.imageView);

        final AnimatedVectorDrawable avd = (AnimatedVectorDrawable) mIcDownloadAnimator.getDrawable();

        avd.registerAnimationCallback(new Animatable2.AnimationCallback() {
            @Override
            public void onAnimationEnd(Drawable drawable) {
                avd.start();
            }
        });

        avd.start();


        rootView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void imageAnimation(View v) {
    }
}
