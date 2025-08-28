package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.Task;
import jinbot.task.TaskList;
import jinbot.JinBotException;

/**
 * Represents a command to delete a task from the task list.
 * The task to delete is specified by its index.
 */
public class DeleteCommand implements Command {
    private final int index;

    /**
     * Constructs a DeleteCommand with the given index string.
     * The string is parsed into a zero-based integer index.
     *
     * @param indexStr The 1-based index of the task to delete, as a string.
     * @throws JinBotException If the index string is not a valid integer.
     */
    public DeleteCommand(String indexStr) throws JinBotException {
        try {
            this.index = Integer.parseInt(indexStr) - 1;
        } catch (NumberFormatException e) {
            throw new JinBotException(
                "Error! jinbot.task.Task number must be a valid integer.");
        }
    }

    /**
     * Executes the delete command by removing the task at the specified index
     * from the task list, and displaying a confirmation message through the UI.
     *
     * @param ui       The UI instance that handles user interaction.
     * @param taskList The task list from which the task is removed.
     */
    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task removed = taskList.removeTask(index);
        ui.printBox("Noted. I've removed this task:\n  " + removed
            + "\nNow you have " + taskList.getSize()
            + " tasks in the list.");
    }
}
