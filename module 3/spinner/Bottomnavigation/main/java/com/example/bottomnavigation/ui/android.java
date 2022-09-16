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

public class android extends Fragment {

    ListView listView;
    List<Model> list;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_android, container, false);

        listView = view.findViewById(R.id.list);
        list = new ArrayList<>();

        list.add(new Model("Android",R.drawable.a1));

        Myadapter myadapter= new Myadapter(getActivity(),list);
        listView.setAdapter(myadapter);




         return view;
    }

}