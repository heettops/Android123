package com.example.backgroundcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);

        btn2=findViewById(R.id.btn2);

        linearLayout=findViewById(R.id.linearlayout);

        btn1.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                linearLayout.setBackgroundResource(R.color.red);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                linearLayout.setBackgroundResource(R.color.orange);
            }
        });
    }
}