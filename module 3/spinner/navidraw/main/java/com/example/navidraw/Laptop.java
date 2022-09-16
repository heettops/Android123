package com.example.navidraw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class Laptop extends Fragment {


    GridView gridView;
    List<Model> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_laptop, container, false);

        gridView=view.findViewById(R.id.grid);


        list=new ArrayList<>();

        list.add(new Model("Laptop",R.drawable.l1));
        list.add(new Model("Gaming",R.drawable.l2));
        list.add(new Model("Graphics",R.drawable.l3));
        list.add(new Model("SSD",R.drawable.l4));

        MyAdapter myAdapter = new MyAdapter(getActivity(),list);
        gridView.setAdapter(myAdapter);
        return view;

    }
}