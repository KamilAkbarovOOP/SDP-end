class DeadlineDecorator extends Task {
    private Task task;
    private String deadline;

    public DeadlineDecorator(Task task, String deadline) {
        super(task.getDescription());
        this.task = task;
        this.deadline = deadline;
    }

    @Override
    public String getPriority() {
        return task.getPriority();
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String getDescription() {
        String priority = task.getPriority();
        return super.getDescription() + priority + "   -   " + deadline;
    }
} //Deadline Decorator adds deadline for task