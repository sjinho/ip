package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.TaskList;

public interface Command {
    void execute(Ui ui, TaskList taskList);
}
