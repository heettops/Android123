package com.example.whatsapptab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    ListView listView;
    List<Model> list;
    View view;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_chat, container, false);
        listView=view.findViewById(R.id.list);
        list=new ArrayList<>();

        list.add(new Model("Heet","how are you?","now",R.drawable.pizza));
        list.add(new Model("Kaushal","Hello","12:20",R.drawable.dosa));
        list.add(new Model("mayank","are you ok?","11:10",R.drawable.paasta));

        MyAdapter2 myAdapter2=new MyAdapter2(getActivity(),list);
        listView.setAdapter(myAdapter2);
        return view;
    }
}