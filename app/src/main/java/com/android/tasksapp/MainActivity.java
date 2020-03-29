package com.android.tasksapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int NUM_REQUEST = 123;
    MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Rows for test
//        DataManager.addTask(new Task("test1", "note1"));
//        DataManager.addTask(new Task("test2", "note2"));
//        DataManager.addTask(new Task("test3", "note3"));
//        DataManager.addTask(new Task("test4", "note4"));
//        DataManager.addTask(new Task("test5", "note5"));


        RecyclerView rv = findViewById(R.id.rv_list);
        adapter = new MainActivityAdapter();
        rv.setAdapter(adapter);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() { //Action of button "Add Task"
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AddTask.class);
                startActivityForResult(intent, NUM_REQUEST); //moving to the page "AddTask.java" temporary, with receive result
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        UpdateTaskFragment fragment = new UpdateTaskFragment();
        transaction.add(R.id.frame_view, fragment);
        transaction.commit();
    }

    // here start work after we finish work with temporary page.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NUM_REQUEST && resultCode == RESULT_OK){ //checking number request, and result of action in the page
            adapter.addTask(); //making update of RecycleView, becouse we made update Task List
//            Toast.makeText(getBaseContext(), "Task Added", Toast.LENGTH_LONG).show(); // this code, just for test
//            MainActivityAdapter adapter2 = new MainActivityAdapter();
//            RecyclerView rv = findViewById(R.id.rv_list);
//            rv.setAdapter(adapter2);
        }else{
            Toast.makeText(getBaseContext(), "Had nay mistake!", Toast.LENGTH_LONG).show();
        }
    }
}
