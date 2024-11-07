import java.util.List;

public class TaskManagerFacade {
    private final TaskManager taskManager = TaskManager.getInstance();
    private TaskSortStrategy sortStrategy;

    public void setSortStrategy(TaskSortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }


    public void addTask(String description, String priority, String deadline) {

        Task task = TaskFactory.createTask(priority, description);


        if (deadline != null && !deadline.isEmpty()) {
            task = new DeadlineDecorator(task, deadline);
        }


        Command addTaskCommand = new AddTaskCommand(taskManager, task);


        taskManager.addCommand(addTaskCommand);
    }


    public void addCompositeTask(CompositeTask compositeTask) {
        taskManager.addTask(compositeTask);
    }


    public void addExternalTask(String info) {
        Task externalTask = new ExternalTaskAdapter(new ExternalTask(info));
        taskManager.addTask(externalTask);
    }


    public void listTasks() {
        List<Task> tasks = taskManager.getTasks();
        if (sortStrategy != null) {
            sortStrategy.sort(tasks);
        }
        taskManager.listTasks();
    }


    public void addObserver(Observer observer) {
        taskManager.addObserver(observer);
    }


    public void undoLastCommand() {
        taskManager.undoLastCommand();  // Делегируем задачу TaskManager
    }
}