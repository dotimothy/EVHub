package com.example.evhub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Method which codes the splash screen (screen before home page)
 */
public class Splash extends AppCompatActivity {

    @Override
    /**
     * Method which creates the splash screen for the app
     * @param savedInstanceState the current state of which fragment the app is on
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            /**
             * Method which determines how fast the splash screen animation is
             */
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        }, 1500);
    }
}
