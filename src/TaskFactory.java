public class TaskFactory {
    public static Task createTask(String type, String description) {
        switch (type.toLowerCase()) {
            case "high":
                return new HighPriorityTask(description);
            case "low":
                return new LowPriorityTask(description);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
//Factory: creates and returns an object of High or Low Priority task type