package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Mode>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        list=new ArrayList<>();

        RecyclerView.LayoutManager rl=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(rl);


        list.add(new Mode("PIZZA",R.drawable.pizza));
        list.add(new Mode("Dosa",R.drawable.dosa));
        list.add(new Mode("PASSTA",R.drawable.paasta));
        list.add(new Mode("CHEESE PIZZA",R.drawable.pizza1));


        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(myAdapter);


    }
}