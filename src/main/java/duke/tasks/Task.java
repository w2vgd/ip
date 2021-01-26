package duke.tasks;

public abstract class Task {
    private final String taskType;
    private final String name;
    private boolean isCompleted;

    public Task(String taskType, String name) {
        this.taskType = taskType;
        this.name = name;
        this.isCompleted = false;
    }

    public Task(String taskType, String name, boolean isCompleted) {
        this.taskType = taskType;
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public String getName() {
        return name;
    }

    public abstract String getTaskType();

    public boolean isDone() {
        return isCompleted;
    }

    public void completeTask() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", (isCompleted ? "X" : " "), name);
    }
}
