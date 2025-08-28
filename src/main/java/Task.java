public class Task {
    private final String taskName;
    private boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public boolean getisDone() {
        return this.isDone;
    }

    public String getTaskName() {
        return taskName;
    }

    public String toSaveFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + taskName;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.getTaskName();
    }


}
