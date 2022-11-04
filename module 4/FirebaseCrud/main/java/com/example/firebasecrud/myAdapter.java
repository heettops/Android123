package com.example.firebasecrud;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class myAdapter extends FirebaseRecyclerAdapter<Model,myAdapter.myviewholder>

{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myAdapter(@NonNull FirebaseRecyclerOptions options)

    {
        super(options);
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {

         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);


        return new myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Model model) {

             holder.name.setText(model.getN());
             holder.email.setText(model.getE());
             holder.pass.setText(model.getP());

             holder.img1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     Toast.makeText(view.getContext(), "Updated", Toast.LENGTH_SHORT).show();

                     final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img1.getContext())
                             .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                             .setExpanded(true,1100)
                             .create();

                     View myview=dialogPlus.getHolderView();

                     final EditText name=myview.findViewById(R.id.edt1);
                     final EditText pass=myview.findViewById(R.id.edt2);
                     final EditText email=myview.findViewById(R.id.edt3);
                     Button btn1=myview.findViewById(R.id.btn1);

                     btn1.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {


                             Map<String,Object> map=new HashMap<>();

                             map.put("n",name.getText().toString());
                             map.put("e",email.getText().toString());
                             map.put("p",pass.getText().toString());

                             FirebaseDatabase.getInstance().getReference().child("h1")
                                     .child(getRef(position).getKey()).updateChildren(map)
                                     .addOnSuccessListener(new OnSuccessListener<Void>() {
                                         @Override
                                         public void onSuccess(Void unused) {

                                             dialogPlus.dismiss();

                                             Toast.makeText(email.getContext(), "Updated", Toast.LENGTH_SHORT).show();
                                         }
                                     })
                                     .addOnFailureListener(new OnFailureListener() {
                                         @Override
                                         public void onFailure(@NonNull Exception e) {

                                             dialogPlus.dismiss();
                                         }
                                     });



                         }
                     });


                     name.setText(model.getN());
                     email.setText(model.getE());
                     pass.setText(model.getP());

                     dialogPlus.show();
                 }
             });

             holder.img2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     AlertDialog.Builder alert=new AlertDialog.Builder(holder.img2.getContext());

                     alert.setTitle("Delete ?");

                     alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {

                             FirebaseDatabase.getInstance().getReference().child("h1")
                                     .child(getRef(position).getKey()).removeValue();

                             notifyItemRangeChanged(position,0);
                         }
                     });

                     alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {

                             dialogInterface.cancel();
                         }
                     });

                     alert.show();
                 }
             });

    }


    class myviewholder extends RecyclerView.ViewHolder
    {


        TextView name,email,pass;
        ImageView img1,img2;




        public myviewholder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.txt1);
            email=itemView.findViewById(R.id.txt2);
            pass=itemView.findViewById(R.id.txt3);
            img1=itemView.findViewById(R.id.img1);
            img2=itemView.findViewById(R.id.img2);


        }
    }
}
