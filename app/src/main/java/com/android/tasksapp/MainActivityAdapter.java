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
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row, parent, false);
        return new MainActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityViewHolder holder, int position) {
        holder.nameTask.setText(DataManager.getTasks().get(position).getNameTask());
        holder.taskNote.setText(DataManager.getTasks().get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return DataManager.getTasks().size();
    }

    public void addTask(){
        notifyDataSetChanged();
    }
}

class MainActivityViewHolder extends RecyclerView.ViewHolder {

    TextView nameTask;
    TextView taskNote;
    public MainActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTask = itemView.findViewById(R.id.name_task);
        taskNote = itemView.findViewById(R.id.task_note);
    }
}