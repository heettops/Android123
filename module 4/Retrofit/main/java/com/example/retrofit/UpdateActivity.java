package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1;
    Apiinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent i=getIntent();
        int id=i.getIntExtra("id",101);
        String name=i.getStringExtra("name");
        String price=i.getStringExtra("price");
        String description=i.getStringExtra("description");

        apiinterface=Apiclient.getapiclient().create(Apiinterface.class);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);


        edt1.setText(name);
        edt2.setText(price);
        edt3.setText(description);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edt1.getText().toString();
                String price=edt2.getText().toString();
                String description=edt3.getText().toString();


                Call<Void>productupdate=apiinterface.productupdate(id,name,price,description);

                productupdate.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {


                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(UpdateActivity.this,MainActivity2.class));


                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(UpdateActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}