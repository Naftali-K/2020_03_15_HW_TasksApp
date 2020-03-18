package com.android.tasksapp;

import java.util.ArrayList;

public class DataManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ArrayList<Task> tasks) {
        DataManager.tasks = tasks;
    }

    public static void addTask(Task task){
        tasks.add(task);
    }
}
