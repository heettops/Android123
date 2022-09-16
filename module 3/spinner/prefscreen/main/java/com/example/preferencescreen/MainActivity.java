package com.example.preferencescreen;

import static android.Manifest.permission.CALL_PHONE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;
    SharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);

        sharedPreferences=getSharedPreferences("User_Session", Context.MODE_PRIVATE);

        if(!(checkSelfPermission(CALL_PHONE)==PackageManager.PERMISSION_GRANTED));

        {
            requestPermissions(new String[]{CALL_PHONE},100);

        }

        if(sharedPreferences.getBoolean("User_Session",false)&& !sharedPreferences.getString("e1","").isEmpty()))
        {
            startActivity();
        }
    }
}