package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText edt1,edt2,edt3,edt4,edt5;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        edt4=findViewById(R.id.edt4);
        edt5=findViewById(R.id.edt5);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String First=edt1.getText().toString();
                String Last=edt2.getText().toString();
                String email=edt3.getText().toString();
                String pass=edt4.getText().toString();
                String cpass=edt5.getText().toString();

                if(pass.equals(cpass)) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("n1", First);
                    i.putExtra("l1", Last);
                    i.putExtra("e1", email);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "password must be same", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}