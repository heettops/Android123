package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView red,orange,green;
    SeekBar seek1,seek2,seek3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek1=findViewById(R.id.seek1);
        seek2=findViewById(R.id.seek2);
        seek3=findViewById(R.id.seek3);
        imageView =findViewById(R.id.img);

        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        seek3.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int r=seek1.getProgress();
        int o=seek2.getProgress();
        int b1=seek3.getProgress();

        imageView.setBackgroundColor(Color.rgb(r,o,b1));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}