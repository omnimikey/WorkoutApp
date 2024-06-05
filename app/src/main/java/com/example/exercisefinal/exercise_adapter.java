package com.example.exercisefinal;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class exercise_adapter extends RecyclerView.Adapter<exercise_adapter.ViewHolder> {

    private ArrayList<exercise_list> exerciseview_list;

    private Context context;

    private boolean state_back;

    static public int[] button_switcher={0,0,0,0,0}; //for main button to select all neededed exercises
    public exercise_adapter(ArrayList<exercise_list> exerciseview_list, Context context) {
        this.exerciseview_list = exerciseview_list;
        this.context = context;
    }

    @NonNull
    @Override
    public exercise_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainview_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull exercise_adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(exerciseview_list.get(position).getImage());
        holder.textView.setText(exerciseview_list.get(position).getText());
        int post = exerciseview_list.get(position).getPage_position();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);

                if (state_back) {
                    GifImageView gifImageView = v.findViewById(R.id.imageView);
                    gifImageView.setBackgroundColor(Color.GREEN);
                    TextView txtview1 = v.findViewById(R.id.textView);
                    txtview1.setBackgroundColor(Color.GREEN);

                    state_back=false;
                    button_switcher[post]= 1; //switches the post
                }else {
                    GifImageView gifImageView = v.findViewById(R.id.imageView);
                    gifImageView.setBackgroundColor(Color.WHITE);
                    TextView txtview1 = v.findViewById(R.id.textView);
                    txtview1.setBackgroundColor(Color.WHITE);
                    state_back=true;
                    button_switcher[post]=0; //switches the post
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseview_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        Button main_button;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            main_button = itemView.findViewById(R.id.mainbutton);
        }
}


}
