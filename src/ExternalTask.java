class ExternalTask { //External task class with incompatible interface for Adapter check
    private String info;

    public ExternalTask(String info) {
        this.info = info;
    }

    public String getDetails() {
        return info;
    }
}