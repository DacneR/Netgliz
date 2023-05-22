package com.example.netgliz;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {
    private List<ListElement> mData;
    private LayoutInflater minflater;
    private Context context;

    final ListAdapter.OnItemClickListener listener;

    public  interface OnItemClickListener{
        void onItemClick(ListElement item);
    }



    public ListAdapter(List<ListElement> itemlist, Context context,ListAdapter.OnItemClickListener listener){
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemlist;
        this.listener = listener;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element,parent,false);
        return new viewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.binData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class viewHolder extends  RecyclerView.ViewHolder{
        TextView name, descrip, genero;
        ImageView img;

        CardView cv;

        viewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            descrip = itemView.findViewById(R.id.descripTextView);
            genero = itemView.findViewById(R.id.generoTextView);
            cv = itemView.findViewById(R.id.cardView);
            img = itemView.findViewById(R.id.iconoImageView);

        }

        void binData(final  ListElement item){
            name.setText(item.getName());
            descrip.setText(item.getDescrip());
            genero.setText(item.getGenero());
            img.setImageResource(item.getImg());


            try {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(item);
                    }
                });
            }catch (Exception e){
                Log.i("DEPURACION", "error capturado en bindata Listadapter" + e);
            }

        }
    }
}
