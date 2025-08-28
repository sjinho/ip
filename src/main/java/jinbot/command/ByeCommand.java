package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.TaskList;

/**
 * Represents the command to terminate the program.
 * When executed, it signals the UI to display the goodbye message
 * and ends the user session.
 */
public class ByeCommand implements Command {

    @Override
    public void execute(Ui ui, TaskList taskList) {
        ui.showGoodbye();
    }
}
