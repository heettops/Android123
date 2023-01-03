package com.example.animationwithsplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    private static int Splash_time=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.txt1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                finish();

            }
        },Splash_time);

        Animation myanim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation2);
        txt.setAnimation(myanim);
    }
}