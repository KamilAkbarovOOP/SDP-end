public abstract class Task { //Abstract class for simple task
    protected String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public abstract String getPriority();
}