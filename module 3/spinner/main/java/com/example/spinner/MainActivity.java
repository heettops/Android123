package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    String name[] = {"heet", "kaushal", "mayank", "harsh"};
    String city[] = {"rajkot", "ahemdabad", "jamnagar", "dwarka"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spin);
        autoCompleteTextView = findViewById(R.id.auto);
        autoCompleteTextView.setThreshold(1);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, name);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + name[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.select_dialog_item, city);

        autoCompleteTextView.setAdapter(arrayAdapter1);
    }
}

