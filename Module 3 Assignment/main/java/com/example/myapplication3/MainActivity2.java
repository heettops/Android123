package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{
TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);

        Intent i=getIntent();
        String n= getIntent().getStringExtra("n1");
        String l= getIntent().getStringExtra("l1");
        String e= getIntent().getStringExtra("e1");

        txt1.setText("Your first name is:"+n);
        txt2.setText("Your last name is:"+l);
        txt3.setText("Your email-id is:"+e);
    }
}