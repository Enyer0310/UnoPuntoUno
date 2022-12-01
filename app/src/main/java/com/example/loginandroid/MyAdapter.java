package com.example.loginandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Jugador> list;

    public MyAdapter(Context context, ArrayList<Jugador> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_element,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Jugador jugador = list.get(position);
        holder.nombreTextView.setText(jugador.getNombre());
        holder.nacionalidadTextView.setText(jugador.getNacionalidad());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombreTextView, nacionalidadTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            nacionalidadTextView = itemView.findViewById(R.id.nacionalidadTextView);

        }
    }
}
