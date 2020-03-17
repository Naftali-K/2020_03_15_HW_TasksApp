package com.android.tasksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView taskNameView = findViewById(R.id.task_name);
                    String taskName = taskNameView.getText().toString();
                TextView taskNoteView = findViewById(R.id.task_note);
                    String taskNote = taskNoteView.getText().toString();

                if(taskName.equals("")){
                    Toast.makeText(getBaseContext(), "You not wrode name task", Toast.LENGTH_LONG).show();
                }else{

                    Task task = new Task(taskName, taskNote); //making new task
                    //option 1
                    DataManager.addTask(task); //add new task to list of tasks

                    //option 2
                    JSONObject object = new JSONObject();
                    try {
                        object.put("NameTask", taskName);
                        object.put("note", taskNote);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent();
                        intent.putExtra("newTask", object.toString()); //for option 2

                    setResult(Activity.RESULT_OK, intent); //back with result OK
                    finish(); //close this LayOut
                }
            }
        });
    }
}
