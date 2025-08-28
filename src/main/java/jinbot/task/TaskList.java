package jinbot.task;

import java.util.List;
import java.util.ArrayList;

public class TaskList {
    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public Task removeTask(int index) {
        return tasks.remove(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String toNumberedListItems() {
        if (tasks.isEmpty()) {
            return "No tasks yet.";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1).append(". ").append(tasks.get(i));
            if (i < tasks.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }
}
