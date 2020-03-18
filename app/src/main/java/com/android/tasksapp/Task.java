package com.android.tasksapp;

public class Task {
    private String NameTask;
    private String note;
    private Statuses status;

    public Task() {
    }

    public Task(String nameTask, String note, Statuses status) {
        this.NameTask = nameTask;
        this.note = note;
        this.status = status;
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

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
