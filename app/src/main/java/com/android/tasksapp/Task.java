package com.android.tasksapp;

public class Task {
    private String NameTask;
    private String note;

    public Task() {
    }

    public Task(String nameTask, String note) {
        NameTask = nameTask;
        this.note = note;
    }

    public String getNameTask() {
        return NameTask;
    }

    public void setNameTask(String nameTask) {
        NameTask = nameTask;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
