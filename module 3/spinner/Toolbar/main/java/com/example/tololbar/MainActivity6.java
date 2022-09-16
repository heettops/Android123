package com.example.tololbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        txt1=findViewById(R.id.txt1);

        txt2=findViewById(R.id.txt2);

        Intent o=getIntent();

    }
}