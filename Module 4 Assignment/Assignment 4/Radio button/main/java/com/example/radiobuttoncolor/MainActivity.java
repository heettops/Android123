package com.example.radiobuttoncolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rb1,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.rdg);


        rb1=findViewById(R.id.rb1);



        rb3=findViewById(R.id.rb3);


        rb4=findViewById(R.id.rb4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId)
                {
                    case R.id.rb1:
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        break;


                    case R.id.rb3:
                        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                        break;


                    case R.id.rb4:
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                        break;

                }
            }
        });


    }
}