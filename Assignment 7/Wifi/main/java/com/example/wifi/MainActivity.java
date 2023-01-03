package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnon1,btnoff1;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnon1=findViewById(R.id.btnon1);
        btnoff1=findViewById(R.id.btnoff1);

        btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                      WifiManager wifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                      wifi.setWifiEnabled(true);
            }
        });


        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WifiManager wifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });
    }


}