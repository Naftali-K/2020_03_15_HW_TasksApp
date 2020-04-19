package com.android.tasksapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDAO {

    @Insert
    public long addTask(Task task);

    @Update
    public void updateTaskByObject(Task task);

    @Delete
    public void deleteTaskByObject(Task task);

    @Query("SELECT * FROM tasks")
    public List<Task> getAllTasks();
}
