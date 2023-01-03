package com.example.controlsex;

import static android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE;
import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText edt1;
    Button btn1;
    TextToSpeech tts = null;
    ImageView imageView, imageView2;
    Button btnon, btnoff,btnon1,btnoff1;
    BluetoothAdapter bluetoothAdapter;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt1 = findViewById(R.id.edt1);
        btn1 = findViewById(R.id.btn1);
        tts = new TextToSpeech(getApplicationContext(),this);
        imageView = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        btnon = findViewById(R.id.btnon);
        btnoff = findViewById(R.id.btnoff);
        btnon1 = findViewById(R.id.btnon1);
        btnoff1 = findViewById(R.id.btnoff1);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);

            }
        });
        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);

            }
        });
        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bluetoothAdapter == null)

                {
                    Toast.makeText(getApplicationContext(), "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                }


                else

                {
                    Toast.makeText(getApplicationContext(), "Bluetooth  Supported", Toast.LENGTH_SHORT).show();


                    if (!bluetoothAdapter.isEnabled())


                    {
                        Intent i1 = new Intent(ACTION_REQUEST_ENABLE);
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivityForResult(i1, 1);
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                bluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,1);

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data =edt1.getText().toString();

                tts.speak(data,TextToSpeech.QUEUE_ADD,null);



            }
        });


    }

    @Override
    public void onInit(int i) {

        tts.setLanguage(Locale.US);
        tts.setPitch(0.5f);
        tts.setSpeechRate(0.8F);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView2.setImageBitmap(bitmap);

        super.onActivityResult(requestCode, resultCode, data);
    }

}