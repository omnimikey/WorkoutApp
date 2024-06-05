package com.example.exercisefinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;


public class WorkoutActivity extends AppCompatActivity {
    //set end time in seconds
    private int duration = 10;
    private boolean timerRunning = false;
    int r =0;
    //bring in selected workouts
    private int workout_time=0;
    private  String workoutnames="";

    private  int total_sets=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.workout_main);

        final TextView hour = findViewById(R.id.hour);
        final TextView min = findViewById(R.id.min);
        final TextView seconds = findViewById(R.id.second);
        final TextView typeExercise = findViewById(R.id.showExercise);
        final GifImageView gifImageView = findViewById(R.id.timerExView);
        final AppCompatButton startBtn = findViewById(R.id.startBtn);
        final ImageButton logbutton = findViewById(R.id.logbutton);

        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutActivity.this, exDatabase.class);
                startActivity(intent);
            }
        });


        ArrayList<Chest> workoutList = (ArrayList<Chest>) getIntent().getSerializableExtra("timerEx");
        ArrayList<Chest> fill = new ArrayList<Chest>();
        int length = workoutList.size();
        startBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {



                duration= workoutList.get(r).getDuration();
                gifImageView.setImageResource(workoutList.get(r).getImage());
                typeExercise.setText(workoutList.get(r).getName());
                workoutnames = workoutnames + workoutList.get(r).getName() +"\n ";
                workout_time = workout_time +  workoutList.get(r).getDuration();
                total_sets = total_sets + workoutList.get(r).getSets();
                // CHECK if countdown timer is already running or not
                if (!timerRunning){

                    timerRunning = true;

                    new CountDownTimer(duration * 1000, 1000) {
                        @Override
                        public void onTick(long l) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String time  = String.format(Locale.getDefault(),"%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(l),
                                            TimeUnit.MILLISECONDS.toMinutes(l) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(l)),
                                            TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                                    final String[] hourMinSec = time.split(":");

                                    hour.setText(hourMinSec[0]);
                                    min.setText(hourMinSec[1]);
                                    seconds.setText((hourMinSec[2]));
                                }
                            });

                        }

                        @Override
                        public void onFinish() {


                            //reset timer
                            if (r < length-1){
                                r=r+1;
                                workoutnames = workoutnames + workoutList.get(r).getName() +"\n";
                                workout_time = workout_time +  workoutList.get(r).getDuration();
                                total_sets = total_sets + workoutList.get(r).getSets();
                                gifImageView.setImageResource(workoutList.get(r).getImage());
                                typeExercise.setText(workoutList.get(r).getName());
                                duration = workoutList.get(r).getDuration();
                                timerRunning= false;

                            if (r == length-1){
                                MyDatabaseHelper myDB = new MyDatabaseHelper(WorkoutActivity.this);
                                myDB.addWorkout(workoutnames,
                                        total_sets,
                                        workout_time);
                            }
                            start();


                            }
                        }
                    }.start();

                }
                else{

                    Toast.makeText(WorkoutActivity.this, "Finish your workout", Toast.LENGTH_SHORT).show();
                    Toast.makeText(WorkoutActivity.this,workoutnames, Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}