import java.util.ArrayList;
import java.util.List;

class CompositeTask extends Task {
    private final List<Task> subtasks = new ArrayList<>();

    public CompositeTask(String description) {
        super(description);
    }

    public void addSubtask(Task task) {
        subtasks.add(task);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(description + " :\n");
        for (Task subtask : subtasks) {
            sb.append("  - ").append(subtask.getDescription()).append(subtask.getPriority()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String getPriority() {
        return ""; // Composite tasks have no a priority
    }
}
//Composite: For creating composite tasks with subtasks