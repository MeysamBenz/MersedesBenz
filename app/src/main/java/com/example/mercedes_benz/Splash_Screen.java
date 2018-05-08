package com.example.mercedes_benz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    private RelativeLayout splash;
    private TextView splashText;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash__screen );

        splash=(RelativeLayout) findViewById( R.id.splash1 );
        splashText=(TextView) findViewById( R.id.splashText );

        handler=new Handler(  );

        handler.postDelayed( new Runnable() {
            @Override
            public void run() {

                AlphaAnimation alphaAnimation=new AlphaAnimation( 1.0f,0.0f );
                alphaAnimation.setDuration( 4000 );
                alphaAnimation.setFillAfter( true );
                alphaAnimation.setRepeatCount( 1 );
                splash.startAnimation( alphaAnimation );
                startActivity( new Intent( Splash_Screen.this,MainActivity.class ) );

            }
        },5000 );

    }
}
