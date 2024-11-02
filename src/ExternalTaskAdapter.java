class ExternalTaskAdapter extends Task {
    private ExternalTask externalTask;

    public ExternalTaskAdapter(ExternalTask externalTask) {
        super(externalTask.getDetails());
        this.externalTask = externalTask;
    }

    @Override
    public String getPriority() {
        return "External";  // Setting priority for an external task
    }
}
//Adapter: For integration of tasks from another source