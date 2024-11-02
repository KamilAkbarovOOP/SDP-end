public class TaskManagerFacade {
    private final TaskManager taskManager = TaskManager.getInstance();

    public void addTask(String description, String priority, String deadline) {
        Task task = TaskFactory.createTask(priority, description);
        if (deadline != null && !deadline.isEmpty()) {
            task = new DeadlineDecorator(task, deadline);
        }
        taskManager.addTask(task);
    }

    public void addCompositeTask(CompositeTask compositeTask) {
        taskManager.addTask(compositeTask);
    }

    public void addExternalTask(String info) {
        Task externalTask = new ExternalTaskAdapter(new ExternalTask(info));
        taskManager.addTask(externalTask);
    }

    public void listTasks() {
        taskManager.listTasks();
    }
} //Facade: provides a simple interface for managing tasks