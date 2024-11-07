public class AddTaskCommand implements Command {
    private final TaskManager taskManager;
    private final Task task;

    public AddTaskCommand(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.addTask(task);
    }

    @Override
    public void undo() {
        taskManager.removeTask(task);
    }

    public Task getTask() {
        return task;
    }
}
