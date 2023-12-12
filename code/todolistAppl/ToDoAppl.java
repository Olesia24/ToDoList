package todolistAppl;

import todolistAppl.dao.ToDoListImpl;
import todolistAppl.model.Menu;
import todolistAppl.model.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoAppl {
    public static void main(String[] args) {
        System.out.println("Welcome to ToDo Application!");
        ToDoListImpl toDoList = new ToDoListImpl(0);

        while (true) {
            Menu.printMenu();
            System.out.println("Input your choice: ");
            Scanner scanner = new Scanner(System.in);
            try {
                int choice = scanner.nextInt();
                // execute
                switch (choice) {
                    case 1: { //Add Task
                        scanner.nextLine();
                        System.out.println("Input task: ");
                        String task = scanner.nextLine();
                        toDoList.addTask(new Task(task, LocalDate.now()));
                        toDoList.saveTasksToFile("M_todoList/code/todolistAppl/fileName");
                        System.out.println("===============");
                        break;
                    }
                    case 2: { //view of tasks
                        System.out.println("===============");
                        toDoList.viewTask();
                        break;
                    }
                    case 3: { //Remove Task
                        System.out.println("Input task number to remove: ");
                        // Используйте существующий Scanner вместо создания нового
                        int number = scanner.nextInt();
                        System.out.println("================");
                        toDoList.removeTask(number);
                        toDoList.viewTask();
                        System.out.println("================");
                        break;
                    }
                    case 4: { //Save Tasks
                        System.out.println("Saving...");
                        toDoList.saveTasksToFile("M_todoList/code/todolistAppl/fileName");
                        break;
                    }
                    case 5: {//Load Tasks
                        toDoList.loadTasksFromFile("M_todoList/code/todolistAppl/fileName");
                        break;
                    }
                    case 6: { //exit
                        toDoList.exit();
                        break;
                    }
                    default: {
                        System.out.println("Wrong input.");
                        toDoList.exit();
                    }
                }
            } catch (Exception e){
                System.out.println("Wrong input");
            }
        }
    }
}