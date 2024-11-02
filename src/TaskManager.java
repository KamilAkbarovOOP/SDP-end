import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private static TaskManager instance;
    private final List<Task> tasks = new ArrayList<>();

    private TaskManager() {}

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getDescription());
        }
    }
} //Singleton: all operations with tasks are performed through this one object