public class HighPriorityTask extends Task {
    public HighPriorityTask(String description) {
        super(description);
    }

    public String getPriority() {
        return "[High]";
    }
}
