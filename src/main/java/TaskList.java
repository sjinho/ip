import java.util.List;
import java.util.ArrayList;

/**
 * TaskList class which stores and do operations
 * on task list generated.
 *
 * @author Jinho Son
 * @version Level-2
 *
 */

public class TaskList {
    /** Final array list of tasks which stores tasks names */
    private final List<Task> tasks = new ArrayList<>();

    public TaskList() {}

    /**
     * Check whether task arraylist is empty or not.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * It returns the size of the array list of tasks.
     *
     * @return int
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * It returns the specific task located at index inside array list.
     *
     * @param index the index of task to get.
     * @return boolean
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }


    /**
     * It adds given task to array list of tasks.
     *
     * @param task the task to be added
     */
    public void addTask(String task) {
        tasks.add(new Task(task));
    }

    public String toNumberedListItems() {
        if (tasks.isEmpty()) {
            return "No tasks yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1).append(".").append(tasks.get(i));
            if (i < tasks.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }
}
