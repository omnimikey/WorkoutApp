package com.example.exercisefinal;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class chest_adapter extends RecyclerView.Adapter<chest_adapter.ViewHolder>{

    private ArrayList<Chest> chest_list;

    private Context context;

    public ArrayList<Chest> getChest_list() {
        return chest_list;
    }

    int change_background=0;
    private boolean state_back = false;

    public chest_adapter(ArrayList<Chest> chest_list, Context context) {
        this.chest_list = chest_list;
        this.context = context;
    }

    @NonNull
    @Override
    public chest_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chest_adapter.ViewHolder holder, int position) {

        holder.imageView1.setImageResource(chest_list.get(position).getImage());
        holder.textView1.setText(chest_list.get(position).getName().toString());
        holder.textView2.setText("Reps: " + chest_list.get(position).getReps().toString());
        holder.textView3.setText("Sets: " +  chest_list.get(position).getSets().toString());
        holder.textView4.setText("Duration: " + chest_list.get(position).getDuration().toString() + "sec");
        holder.textView5.setText("Pounds: " + chest_list.get(position).getPounds().toString()+ "lbs");
        int pos = position;
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state_back) {
                    GifImageView gifImageView = v.findViewById(R.id.imageView2);
                    gifImageView.setBackgroundColor(Color.YELLOW);
                    TextView txtView = v.findViewById(R.id.exView1);
                    txtView.setBackgroundColor(Color.YELLOW);
                    txtView.setTextColor(Color.BLACK);
                    state_back=false;
                    chest_list.get(pos).setState(true);

                }else {
                    GifImageView gifImageView = v.findViewById(R.id.imageView2);
                    gifImageView.setBackgroundColor(Color.BLACK);
                    TextView txtView = v.findViewById(R.id.exView1);
                    txtView.setBackgroundColor(Color.BLACK);
                    state_back=true;
                    chest_list.get(pos).setState(false);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chest_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView1;
        ImageView imageView1;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView1 = itemView.findViewById(R.id.exerciseView);
            imageView1 = itemView.findViewById(R.id.imageView2);
            textView1 = itemView.findViewById(R.id.exView1);
            textView2 = itemView.findViewById(R.id.exView2);
            textView3 = itemView.findViewById(R.id.exView3);
            textView4 = itemView.findViewById(R.id.exView4);
            textView5 = itemView.findViewById(R.id.exView5);
        }


}
}
