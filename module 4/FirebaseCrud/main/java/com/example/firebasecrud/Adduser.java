package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Adduser extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);


        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=edt1.getText().toString();
                String email=edt2.getText().toString();
                String pass=edt3.getText().toString();

                HashMap<String,String>map=new HashMap<>();

                map.put("n",name);
                map.put("e",email);
                map.put("p",pass);


                FirebaseDatabase.getInstance().getReference().child("h1").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {


                        Toast.makeText(Adduser.this, "Inserted", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Adduser.this,MainActivity.class));
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(Adduser.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}