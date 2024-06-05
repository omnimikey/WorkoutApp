package com.example.exercisefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList workout_id, workout_title, workout_sets, workout_duration;
    CustomAdapter customAdapter;
    CustomAdapter(Context context, ArrayList workout_id,
                  ArrayList workout_title, ArrayList workout_sets,
                  ArrayList workout_duration){
        this.context=context;
        this.workout_id = workout_id;
        this.workout_title=workout_title;
        this.workout_sets=workout_sets;
        this.workout_duration = workout_duration;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.workout_id_txt.setText(String.valueOf(workout_id.get(position)));
        holder.workout_title_txt.setText(String.valueOf(workout_title.get(position)));
        holder.workout_sets_txt.setText(String.valueOf(workout_sets.get(position)));
        holder.workout_duration_txt.setText(String.valueOf(workout_duration.get(position)));
    }

    @Override
    public int getItemCount() {
        return workout_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView workout_id_txt, workout_title_txt, workout_sets_txt, workout_duration_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            workout_id_txt = itemView.findViewById(R.id.workout_id_txt);
            workout_title_txt = itemView.findViewById(R.id.workout_title_txt);
            workout_sets_txt = itemView.findViewById(R.id.workout_sets_txt);
            workout_duration_txt = itemView.findViewById(R.id.workout_duration_txt);
        }
    }

}
