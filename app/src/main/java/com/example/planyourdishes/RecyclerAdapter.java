package com.example.planyourdishes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles=
            {"Chicken Salad", "Salmon Bowl", "Bolognese","Vegetable Udon",
                    "Beef Chow Mein","Chicken Parmesan","Lentil & Tuna Salad","Salmon Pasta"};
    private String[] calories=
            {"353","464","387","366","407","327","374","543"};

    private String[] minutes={"25","28","25", "25", "20", "30", "15", "25"};
    private int[] images=
            {R.drawable.chicken_salad,
                    R.drawable.salmon_bowl,
                    R.drawable.bolognese,
                    R.drawable.vegetable_udon,
                    R.drawable.beef_chow_mein,
                    R.drawable.chicken_parmesan,
                    R.drawable.lentil_tuna_salad,
                    R.drawable.salmon_pasta};




    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.calorie.setText(calories[position]+" kcal");
        holder.title.setText(titles[position]);
        holder.image.setImageResource(images[position]);
        holder.minute.setText(minutes[position]+" min");

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView calorie;

        TextView minute;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.recipe_image);
            title=itemView.findViewById(R.id.recipe_title);
            calorie=itemView.findViewById(R.id.recipe_calorie);
            minute=itemView.findViewById(R.id.recipe_min);
            cardView=itemView.findViewById(R.id.card_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on "+titles[position], Snackbar.LENGTH_LONG )
                            .setAction("Action", null).show();
                }
            });
        }
    }
}
