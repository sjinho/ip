package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.TaskList;

public class ListCommand implements Command {

    @Override
    public void execute(Ui ui, TaskList taskList) {
        String listOutput = taskList.toNumberedListItems();
        ui.printBox("Here are the tasks in your list:\n" + listOutput);
    }
}
