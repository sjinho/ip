package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.TaskList;

public class ByeCommand implements Command {

    @Override
    public void execute(Ui ui, TaskList taskList) {
        ui.showGoodbye();
    }
}
