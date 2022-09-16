package com.example.tololbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

      ListView listView;
      List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();

        list.add(new Model(R.drawable.dosa,"Masala dosa","160"));
        list.add(new Model(R.drawable.burger,"Mayo burger","120"));
        list.add(new Model(R.drawable.paasta,"chilly paasta","210"));
        list.add(new Model(R.drawable.pizza1,"margreta pizza","200"));

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent o =new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(o);

                }

                if(i==1)
                {
                    Intent o =new Intent(MainActivity2.this,MainActivity4.class);
                    startActivity(o);
                }

                if(i==2)
                {
                    Intent o =new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(o);
                }
                if(i==3)
                {
                    Intent o =new Intent(MainActivity2.this,MainActivity6.class);
                    startActivity(o);
                }
            }
        });


    }
}