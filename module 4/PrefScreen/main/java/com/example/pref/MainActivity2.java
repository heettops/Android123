package com.example.pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    Button btn1;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.txt1);
        btn1=findViewById(R.id.btn1);

        sharedPreferences =getSharedPreferences("User_Session", Context.MODE_PRIVATE);

        Toast.makeText(MainActivity2.this, "LOGGED-IN AS "+sharedPreferences.getString("e1","error"), Toast.LENGTH_SHORT).show();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().commit();

                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                finish();
            }
        });

    }
}