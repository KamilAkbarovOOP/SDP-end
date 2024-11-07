import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private static TaskManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private final List<Command> commandHistory = new ArrayList<>();  // История команд

    private TaskManager() {}

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }


    public List<Task> getTasks() {
        return tasks;
    }


    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("New task added: " + task.getDescription());
    }


    public void removeTask(Task task) {
        tasks.remove(task);
        notifyObservers("Task removed: " + task.getDescription());
    }


    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getDescription());
        }
    }


    public void addCommand(Command command) {
        commandHistory.add(command);
        command.execute();
    }


    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
            System.out.println("Last command undone.");
        } else {
            System.out.println("No command to undo.");
        }
    }
}
