package com.example.bottomnavigation.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.bottomnavigation.Model;
import com.example.bottomnavigation.Myadapter;
import com.example.bottomnavigation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class php extends Fragment {

    SliderLayout sliderLayout;
    HashMap<String,Integer> hashMap;


    ListView listView;
    List<Model> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_php, container, false);

        sliderLayout=view.findViewById(R.id.slider);
        hashMap=new HashMap<>();

        hashMap.put("A1",R.drawable.a1);
        hashMap.put("B1",R.drawable.java);
        hashMap.put("C1",R.drawable.php);


        for(String name:hashMap.keySet())
        {
            TextSliderView textSliderView=new TextSliderView(getActivity());
            textSliderView.description(name)
                    .image(hashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage);

            sliderLayout.addSlider(textSliderView);

        }


       listView = view.findViewById(R.id.list);
        list = new ArrayList<>();


        list.add(new Model("Php",R.drawable.php));

        Myadapter myadapter= new Myadapter(getActivity(),list);
        listView.setAdapter(myadapter);



        return view;
    }
}