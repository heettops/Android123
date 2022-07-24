package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String name[]={"heet","kaushal","mayank","harsh"};
    AutoCompleteTextView autoCompleteTextView;
    String city[]={"rajkot","ahemdabad","jamnagar","kutch"};
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner =findViewById(R.id.spin);
        autoCompleteTextView=findViewById(R.id.auto);
        aSwitch=findViewById(R.id.s1);
        autoCompleteTextView.setThreshold(3);

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,name);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)

            {
                Toast.makeText(MainActivity.this, ""+name[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter arrayAdapter1=new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,city);

        autoCompleteTextView.setAdapter(arrayAdapter1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(aSwitch.isChecked())

                {
                    Toast.makeText(MainActivity.this,"ON",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(MainActivity.this,"OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}