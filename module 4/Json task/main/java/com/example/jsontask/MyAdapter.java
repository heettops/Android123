package com.example.jsontask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter

{
    Context context;
    List<Model>list;

    public MyAdapter(Context context, List<Model> list) {

        this.context = context;
        this.list = list;


    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater in =LayoutInflater.from(context);
        view=in.inflate(R.layout.design,viewGroup,false);

        TextView txt1=view.findViewById(R.id.txt1);

        TextView txt2=view.findViewById(R.id.txt2);


        TextView txt3=view.findViewById(R.id.txt3);
        TextView txt4=view.findViewById(R.id.txt4);

        TextView txt5=view.findViewById(R.id.txt5);


        txt1.setText(list.get(i).postId);

        txt2.setText(list.get(i).id);


        txt3.setText(list.get(i).name);


        txt4.setText(list.get(i).email);


        txt5.setText(list.get(i).body);



        return view;
    }
}
