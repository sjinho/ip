package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.Task;
import jinbot.task.TaskList;

/**
 * Represents a command to mark a task in the task list as done.
 */
public class MarkCommand implements Command {
    private final int index;

    /**
     * Constructs a MarkCommand with the given index string.
     * The string is parsed into a zero-based integer index.
     *
     * @param indexString The 1-based index of the task to mark as done, as a string.
     */
    public MarkCommand(String indexString) {
        this.index = Integer.parseInt(indexString) - 1;
    }

    /**
     * Executes the mark command by marking the specified task as done
     * in the task list and displaying a confirmation message.
     *
     * @param ui       The UI instance that handles user interaction.
     * @param taskList The task list containing the task to be marked as done.
     */
    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task taskToMark = taskList.getTask(index);
        taskToMark.markAsDone();

        ui.printBox("Nice! I've marked this task as done:\n  " + taskToMark);
    }
}