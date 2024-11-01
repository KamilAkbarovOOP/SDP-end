public class LowPriorityTask extends Task {
    public LowPriorityTask(String description) {
        super(description);
    }

    public String getPriority() {
        return "[Low]";
    }
}
