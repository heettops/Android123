package com.example.cafeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity2 extends AppCompatActivity {

    CheckBox chk1, chk2, chk3;
    Button btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();
                builder.append("\n Selected items :");
                int amount = 0;

                if (chk1.isChecked()) {
                    amount += 120;
                    builder.append("\n passta...120");
                }

                if (chk2.isChecked()) {
                    amount += 270;
                    builder.append("\n 7 cheese pizza...270 ");
                }

                if (chk3.isChecked()) {
                    amount += 170;
                    builder.append("\n nachos...170 ");
                }


                builder.append("\n -------------");
                builder.append("\n your total amount is "+ amount);

                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("Bill", builder.toString());
                startActivity(i);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="7990663952";
                Intent i=new Intent((Intent.ACTION_CALL));

                i.setData(Uri.parse("tel:"+number));
                startActivity(i);
            }
        });

    }





    }










