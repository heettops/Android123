package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String number=edt1.getText().toString();
                String pass=edt2.getText().toString();


if((number.equals("admin")) && (pass.equals("1234")))
{
    Toast.makeText(MainActivity.this,"login successfully",Toast.LENGTH_SHORT).show();
    Intent i=new Intent(MainActivity.this,MainActivity2.class);
    startActivity(i);
}




               if(number.length()==0 && pass.length()==0)
                {
                    edt1.setError("please enter the username");
                    edt2.setError("please enter the password");

                }

                else if(number.length()==0)
                {
                    edt1.setError("please enter the username");
                }
            else if(pass.length()==0)
                {
                    edt2.setError("please enter the password");

                }

            else
                {
                    Toast.makeText(MainActivity.this,"please enter valid details",Toast.LENGTH_SHORT).show();

                }



            }

        });
    }
}