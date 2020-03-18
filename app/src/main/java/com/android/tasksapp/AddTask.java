package com.android.tasksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
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
                RadioGroup radioGroup = findViewById(R.id.radio_group);
                    int selectedID = radioGroup.getCheckedRadioButtonId();
                    

                if(taskName.equals("")) {
                    Toast.makeText(getBaseContext(), "You not wrote name task", Toast.LENGTH_LONG).show();
                }else if(selectedID == -1){
                    Toast.makeText(getBaseContext(), "You not decided status", Toast.LENGTH_LONG).show();
                }else{

                    RadioButton radioButton = (RadioButton)findViewById(selectedID);
                    //Toast.makeText(getBaseContext(), "you choises: " + radioButton.getText().toString(), Toast.LENGTH_LONG).show();

                    Statuses status;

                    switch (radioButton.getText().toString()){
                        case "To do":
                            status = Statuses.TO_DO;
                            break;
                        case "In Progress":
                            status = Statuses.IN_PROGRESS;
                            break;
                        case "Completed":
                            status = Statuses.COMPLETED;
                            break;
                        default:
                            status = Statuses.NOT_DECIDED;
                    }

                    Task task = new Task(taskName, taskNote, status); //making new task
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
