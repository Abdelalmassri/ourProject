package com.abdel.mijnproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdel.mijnproject.Activity.LoginActivity;
import com.abdel.mijnproject.Activity.SingupActivity;

public class SplashActivity extends Activity {

    private static final int SPLASH_SCREEN_TIME_OUT = 2000; // Duration of splash screen in milliseconds
    ImageView image;
    Animation topAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.image = (ImageView) findViewById(R.id.imageView);
        this.topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        this.image.setAnimation(this.topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close splash screen activity so user can't return to it
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }


}