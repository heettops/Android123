package com.example.bottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Myadapter extends BaseAdapter


{
    Context context;
    List<Model>list;

    public Myadapter(Context context, List<Model> list)

    {

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
        view=in.inflate(R.layout.design,viewGroup,false);
        TextView txt=view.findViewById(R.id.txt);
        ImageView img=view.findViewById(R.id.img);

        txt.setText(list.get(i).topicname);
        img.setImageResource(list.get(i).image);
        return  view;
    }
}
