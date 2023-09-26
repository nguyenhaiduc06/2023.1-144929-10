package MVC;

import java.util.List;
import java.util.Scanner;

public class TaskController {
    private TaskModel model;
    private TaskView view;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void addTask(String task) {
        model.addTask(task);
    }

    public void showTasks() {
        List<String> tasks = model.getTasks();
        view.showTasks(tasks);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.showMessage("Options:");
            view.showMessage("1. Add Task");
            view.showMessage("2. Show Tasks");
            view.showMessage("3. Quit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                view.showMessage("Enter a task:");
                String task = scanner.nextLine();
                addTask(task);
            } else if (choice.equals("2")) {
                showTasks();
            } else if (choice.equals("3")) {
                break;
            } else {
                view.showMessage("Invalid choice. Please try again.");
            }
        }
    }
}