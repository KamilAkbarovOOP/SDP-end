import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;

    private TaskManager() {
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription() + " " + task.getPriority() );
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription() + " " + task.getPriority()) ;
            }
        }
    }
}

//Singleton: all operations with tasks are performed through this one object