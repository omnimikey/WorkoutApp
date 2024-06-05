package com.example.exercisefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<exercise_list> exercise_list;

    RecyclerView mainView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainView = findViewById(R.id.mainView);
        mainView.setHasFixedSize(true);
        mainView.setLayoutManager(new GridLayoutManager(this, 1));

        exercise_list = new ArrayList<exercise_list>();
        exercise_list.add(new exercise_list(R.drawable.chestbenchpress,"Chest",0));
        exercise_list.add(new exercise_list(R.drawable.arms,"Arms",1));
        exercise_list.add(new exercise_list(R.drawable.abdominals2,"Abdominal",2));
        exercise_list.add(new exercise_list(R.drawable.shoulders,"Shoulders",3));
        exercise_list.add(new exercise_list(R.drawable.legs,"Legs",4));


        exercise_adapter exercise_adapter = new exercise_adapter(exercise_list, this);
        mainView.setAdapter(exercise_adapter);

        Button button = findViewById(R.id.mainbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });

    }

}