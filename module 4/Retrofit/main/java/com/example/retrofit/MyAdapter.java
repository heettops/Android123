package com.example.retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview> {
    Context context;
    List<Model>datalist;
    Apiinterface api;

    public MyAdapter(Context context, List<Model> datalist) {
        this.context = context;
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, @SuppressLint("RecyclerView") int position) {

        holder.t1.setText(datalist.get(position).getProduct_name());
        holder.t2.setText(datalist.get(position).getProduct_price());
        holder.t3.setText(datalist.get(position).getProduct_description());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("select operation");
                alert.setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent i2=new Intent(context,UpdateActivity.class);
                        i2.putExtra("id",datalist.get(position).product_id);
                        i2.putExtra("name",datalist.get(position).product_name);
                        i2.putExtra("price",datalist.get(position).product_price);
                        i2.putExtra("description",datalist.get(position).product_description);


                        i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i2);
                    }
                });


                alert.setNegativeButton("Deleted", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        api = Apiclient.getapiclient().create(Apiinterface.class);
                        Call<Void> deletecall = api.productdelete(datalist.get(position).product_id);
                        deletecall.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                Toast.makeText(view.getContext(), "Product deleted", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(context, MainActivity2.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(i);
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });

                alert.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public class Myview extends RecyclerView.ViewHolder {
        TextView t1, t2, t3;

        public Myview(View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.txt1);
            t2 = itemView.findViewById(R.id.txt2);
            t3 = itemView.findViewById(R.id.txt3);
        }
    }
}



