package com.example.e_grettings.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetings.Category

import com.example.e_grettings.Module.Dashboard_Model
import com.example.e_grettings.R
import com.squareup.picasso.Picasso

class Dashboardadapter(var context: Context ,var list: MutableList<Dashboard_Model>) : RecyclerView.Adapter<MyView>()



{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {


        var inflater = LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design_dashboard,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView , position: Int) {

        holder.txt1.setText(list.get(position).c_name)
        Picasso.get().load(list.get(position).c_image).into(holder.img1)


        holder.itemView.setOnClickListener{

            var i = Intent(context, Category::class.java)
            i.putExtra("pos",position)
            //i.putExtra("pos",list.get(position))
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {

        return list.size

    }


}

class MyView(itemview: View) : RecyclerView.ViewHolder(itemview)

{
    var txt1:TextView= itemview.findViewById(R.id.dashboard_txt)
    var img1:ImageView =itemview.findViewById(R.id.dashboard_img)
}