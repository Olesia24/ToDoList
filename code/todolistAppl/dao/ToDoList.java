package todolistAppl.dao;

import todolistAppl.model.Task;

import java.io.Serializable;
import java.util.List;

public interface ToDoList extends Serializable {
    boolean addTask(Task task);
    void viewTask();
    Task removeTask(int taskNumber);
    List<Task> getAllTasks();
    int quantity();
    void exit();
}
