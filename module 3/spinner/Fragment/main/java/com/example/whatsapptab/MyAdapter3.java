package com.example.whatsapptab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter3 extends BaseAdapter {
    Context context;
    List<Model2> list;

    public MyAdapter3(Context context, List<Model2> list) {

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
    public View getView(int i, View view, ViewGroup viewGroup)

    {
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.design_status,viewGroup,false);
        TextView txt1=view.findViewById(R.id.txt1);
        TextView txt2=view.findViewById(R.id.txt2);
        ImageView img=view.findViewById(R.id.img1);

        txt1.setText(list.get(i).title);
        txt2.setText(list.get(i).time);
        img.setImageResource(list.get(i).image);

        return view;
    }
}
