package com.example.bottomnavigation.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bottomnavigation.Model;
import com.example.bottomnavigation.Myadapter;
import com.example.bottomnavigation.R;

import java.util.ArrayList;
import java.util.List;

public class java extends Fragment {
    ListView listView;
    List<Model> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_java, container, false);

        listView = view.findViewById(R.id.list);
        list = new ArrayList<>();


        list.add(new Model("java",R.drawable.java));

        Myadapter myadapter= new Myadapter(getActivity(),list);
        listView.setAdapter(myadapter);

        return view;
    }
}