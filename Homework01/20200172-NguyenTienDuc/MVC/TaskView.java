package MVC;

import java.util.List;

public class TaskView {
    public void showTasks(List<String> tasks) {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
