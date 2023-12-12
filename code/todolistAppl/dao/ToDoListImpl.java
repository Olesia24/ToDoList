package todolistAppl.dao;

import todolistAppl.model.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoListImpl implements ToDoList, Serializable {

    private List<Task> tasks;
    private int quantity;
    private LocalDateTime time;

    public ToDoListImpl(int quantity) {
        this.tasks = new ArrayList<>();
        this.quantity = quantity;
        this.time = LocalDateTime.now();
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        }
        tasks.add(task);
        quantity++;
        return true;
    }

    @Override
    public void viewTask() {
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + 1 + ". " + task);
        }
        System.out.println("You have " + quantity + " tasks.");
    }

    @Override
    public Task removeTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber < quantity) {
            Task removed = tasks.get(taskNumber - 1);
            tasks.remove(removed);
            quantity--;
            return removed;
        }
        System.out.println("Wrong task number");
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks.stream().toList();
    }

    @Override
    public int quantity() {
        return quantity;
    }

    @Override
    public void exit() {
        System.exit(0);
    }
    public void saveTasksToFile(String file) {
        List<Task> tasks = getAllTasks();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(tasks);
            System.out.println("The list of tasks is written to a file");
            } catch (IOException e) {
            e.printStackTrace();
            }
        }

    public void loadTasksFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Task> readTasks = (List<Task>) ois.readObject();
            System.out.println(readTasks);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
