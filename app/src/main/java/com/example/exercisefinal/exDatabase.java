package com.example.exercisefinal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class exDatabase extends AppCompatActivity {

    RecyclerView recyclerView;

    MyDatabaseHelper myDB;
    ArrayList<String> workout_id, workout_title, workout_sets, workout_duration;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_database);

        recyclerView = findViewById(R.id.totalworkoutview);


        myDB = new MyDatabaseHelper(exDatabase.this);
        workout_id = new ArrayList<>();
        workout_title = new ArrayList<>();
        workout_sets = new ArrayList<>();
        workout_duration = new ArrayList<>();


        storeDataInArrays();

        customAdapter = new CustomAdapter(exDatabase.this, workout_id, workout_title, workout_sets, workout_duration);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(exDatabase.this));


    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                workout_id.add(cursor.getString(0));
                workout_title.add("List of Workouts\n\n" + cursor.getString(1));
                workout_sets.add(("Amount of Sets\n\n") + cursor.getString(2));
                workout_duration.add("Duration\n\n" + cursor.getString(3)+" sec");
            }
        }
    }





}
