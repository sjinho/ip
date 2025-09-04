package jinbot.command;

import jinbot.task.TaskList;
import jinbot.ui.Ui;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand implements Command {

    /**
     * Executes the list command by retrieving all tasks from the task list
     * and displaying them through the UI.
     *
     * @param ui       The UI instance that handles user interaction.
     * @param taskList The task list containing the tasks to display.
     */
    @Override
    public void execute(Ui ui, TaskList taskList) {
        String listOutput = taskList.toNumberedListItems();
        ui.printBox("Here are the tasks in your list:\n" + listOutput);
    }
}
