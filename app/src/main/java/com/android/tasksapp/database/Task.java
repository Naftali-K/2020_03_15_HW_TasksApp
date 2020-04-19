package com.android.tasksapp.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.android.tasksapp.Statuses;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nameTask;
    private String note;

    @Ignore
    public Task() {
    }

    public Task(long id, String nameTask, String note) {
        this.id = id;
        this.nameTask = nameTask;
        this.note = note;
    }

    @Ignore
    public Task(String nameTask, String note) {
        this.nameTask = nameTask;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
