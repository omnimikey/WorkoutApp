package com.example.exercisefinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    ArrayList<Chest> chest_list;

    public ArrayList<Chest> getChest_list() {
        return chest_list;
    }

    private ArrayList<Chest> workout_list= new ArrayList<Chest>();

    public ArrayList<Chest> getWorkout_list() {
        return workout_list;
    }

    RecyclerView exerciseView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.exercise_main);

        exerciseView = findViewById(R.id.exerciseView1);
        exerciseView.setHasFixedSize(true);
        exerciseView.setLayoutManager(new GridLayoutManager(this,1));

        chest_list = new ArrayList<Chest>();
        if (exercise_adapter.button_switcher[0] == 1) {
            chest_add(chest_list);
        }

        if (exercise_adapter.button_switcher[1] == 1){
            arms_add(chest_list);

        }

        if (exercise_adapter.button_switcher[2] == 1){
            abdominal_add(chest_list);
        }

        if (exercise_adapter.button_switcher[3] == 1){
            shoulder_add(chest_list);
        }

        if (exercise_adapter.button_switcher[4] == 1){
            leg_add(chest_list);
        }

        chest_adapter chest_adapter = new chest_adapter(chest_list, this);
        exerciseView.setAdapter(chest_adapter);

        Button button = findViewById(R.id.exercisebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                workout_list.clear();

                ArrayList<Chest> chester = chest_adapter.getChest_list();

                for (int i=0; i < chester.size(); i++){
                    if (chester.get(i).getState() == true){
                        if (!workout_list.contains(chester.get(i))) {
                            workout_list.add(chester.get(i));
                        }
                    }
                }
                Intent intent = new Intent(ExerciseActivity.this,WorkoutActivity.class);
                intent.putExtra("timerEx", workout_list);
                startActivity(intent);

            }
        });

    }

    private void chest_add(ArrayList<Chest> ex){
        ex.add(new Chest("Bench Press",R.drawable.benchpress,10,4,5,160,1,2000L,false));
        ex.add(new Chest("Dumbbell Bench Press",R.drawable.dumbbellbenchpress,10,3,5,100,2,2000L, false));
        ex.add(new Chest("Dumbbell Fly",R.drawable.dumbbellfly,10,3,5,100, 3, 3000L, false));
        ex.add(new Chest("Dumbbell Pullover",R.drawable.dumbbellpullovere,10,3,5,100,4,4000L, false));
        ex.add(new Chest("Inclined Dumbbell Fly",R.drawable.inclinedumbbellfly,10,3,5,100, 5, 4000L, false));
        ex.add(new Chest("Incline Dumbbell Press",R.drawable.inclinedumbbellpress,10,3,5,100, 6, 3000L, false));
        ex.add(new Chest("Reverse Grip Dumbbell Press",R.drawable.reversegripdumbbellpress,10,3,5,100, 7, 3000L, false));
    }

    private void arms_add(ArrayList<Chest> ex){
        ex.add(new Chest("Chest Press",R.drawable.arms1,10,4,5,160,8, 2000L, false));
        ex.add(new Chest("Barbell Curl",R.drawable.barbellcurl,10,4,5,160, 9, 4000L, false));
        ex.add(new Chest("Dumbbell Curl",R.drawable.dumbbellcurl,10,4,5,160, 10, 5000L, false));
        ex.add(new Chest("Dumbbell High Curl",R.drawable.dumbbellhighcurl,10,4,5,160, 11, 4000L, false));
        ex.add(new Chest("Dumbbell Reverse Curl",R.drawable.dumbbellreversecurl,10,4,5,160, 12, 4000L, false));
        ex.add(new Chest("Hammer Curl",R.drawable.hammercurl,10,4,5,160, 13, 3000L, false));
        ex.add(new Chest("Seated Incline Dumbbell Curl",R.drawable.seatedinclinecumbbellcurl,10,4,5,160, 14, 4000L, false));
        ex.add(new Chest("Seated Zottan Curl",R.drawable.seatedzottancurl,10,4,5,160,15, 3000L, false));
        ex.add(new Chest("Standing Barbell Concentration Curl",R.drawable.standingbarbellconcentrationcurl,10,4,5,160, 16, 4000L, false));
    }

    private void abdominal_add(ArrayList<Chest> ex){
        ex.add(new Chest("Cross Crunch",R.drawable.crosscrunch,10,4,5,160, 17, 3999L, false));
        ex.add(new Chest("Crunch",R.drawable.crunch,10,4,5,160,18, 3500L, false));
        ex.add(new Chest("Decline Situp",R.drawable.declinesitup,10,4,5,160, 19, 4000L, false));
        ex.add(new Chest("Lying Leg Raise",R.drawable.lyinglegraise,10,4,5,160, 20, 3000L, false));
        ex.add(new Chest("Reverse Crunch",R.drawable.reversecrunch,10,4,5,160, 21, 6000L, false));
        ex.add(new Chest("Seated Bench Leg Pull In",R.drawable.seatedbenchlegpullin,10,4,5,160, 22,5000L, false));
    }

    private void shoulder_add(ArrayList<Chest> ex){
        ex.add(new Chest("Alternate Dumbbell Raise",R.drawable.alternatedumraise,10,4,5,160, 23, 4000L, false));
        ex.add(new Chest("Shoulder Raise",R.drawable.shoulderraise,10,4,5,160, 24, 3000L, false));
        ex.add(new Chest("Side Shoulder Raise",R.drawable.sideshoulderraise,10,4,5,160, 25, 4500L, false));
        ex.add(new Chest("Sitting Shoulder Raise",R.drawable.sittingshoulderraise,10,4,5,160, 26, 3400L, false));
        ex.add(new Chest("Weight Raise",R.drawable.weightraise,10,4,5,160, 27,4000L, false));
    }

    private void leg_add(ArrayList<Chest> ex){
        ex.add(new Chest("Barbell Deadlift",R.drawable.barbelldeadlift,10,4,5,160,28,3400L, false));
        ex.add(new Chest("Barbell Lunge",R.drawable.barbelllunge,10,4,5,160, 29, 2800L, false));
        ex.add(new Chest("Bodyweight Lunges",R.drawable.bodyweightlunges,10,4,5,160, 30, 3700L, false));
        ex.add(new Chest("Dumbbell Squat",R.drawable.dumbbellsquat,10,4,5,160, 31, 4200L, false));
        ex.add(new Chest("Goblet Squat",R.drawable.gobletsquat,10,4,5,160, 32, 4004L, false));
        ex.add(new Chest("Barbell Squat",R.drawable.barbellsquat,10,4,5,160, 33, 3000L, false));
        ex.add(new Chest("Standing Leg Circles",R.drawable.standinglegcircles,10,4,5,160, 34, 4000L, false));
        ex.add(new Chest("Static Lunge",R.drawable.staticlunge,10,4,5,160, 35, 3400L, false));
        ex.add(new Chest("Straight Leg Deadlift",R.drawable.straightlegdeadlift,10,4,5,160, 36, 2700L, false));
        ex.add(new Chest("Walking Lunge",R.drawable.walkinglunge,10,4,5,160, 37, 5400L, false));
    }

}
