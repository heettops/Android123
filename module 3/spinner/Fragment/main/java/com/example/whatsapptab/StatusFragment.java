package com.example.whatsapptab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StatusFragment extends Fragment {

    ListView listView;
    List<Model2> list;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_status, container, false);
        listView = view.findViewById(R.id.list);
        list = new ArrayList<>();

        list.add(new Model2("Heet","10 minutes ago",R.drawable.a1));
        list.add(new Model2("kaushal","20 minutes ago",R.drawable.dosa));
        list.add(new Model2("Harsh","30 minutes ago",R.drawable.paasta));
        list.add(new Model2("Manthan","45 minutes ago",R.drawable.pizza));


       MyAdapter3 myAdapter3=new MyAdapter3(getActivity(),list);
        listView.setAdapter(myAdapter3);
        return view;



    }
}