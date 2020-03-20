package com.android.tasksapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityViewHolder> {
    @NonNull
    @Override
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //here we decide with which one LayOut we will work (which Layout will replay)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row, parent, false);
        return new MainActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityViewHolder holder, int position) { // here we add information for Layout
        holder.nameTask.setText(DataManager.getTasks().get(position).getNameTask());
        holder.taskNote.setText(DataManager.getTasks().get(position).getNote());
        holder.taskStatus.setText(DataManager.getTasks().get(position).getStatus().toString());
    }

    @Override
    public int getItemCount() { //here we set number replays/number items in list
        return DataManager.getTasks().size();
    }

    public void addTask(){ // here we making
        notifyDataSetChanged();
    }
}

class MainActivityViewHolder extends RecyclerView.ViewHolder { // here we decide which View we well use for update information

    TextView nameTask, taskNote, taskStatus;

    public MainActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTask = itemView.findViewById(R.id.name_task);
        taskNote = itemView.findViewById(R.id.task_note);
        taskStatus = itemView.findViewById(R.id.task_status);
    }
}