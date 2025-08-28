package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.TaskList;

/**
 * Represents a command that can be executed by JinBot.
 * Each command performs an action on the task list and interacts with the UI.
 */

public interface Command {
    /**
     * Executes the command using the given UI and task list.
     *
     * @param ui       The UI instance that handles user interaction.
     * @param taskList The list of tasks to be modified or displayed.
     */
    void execute(Ui ui, TaskList taskList);
}
