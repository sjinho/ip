package jinbot.command;

import jinbot.task.Task;
import jinbot.task.TaskList;
import jinbot.ui.Ui;

public class UnmarkCommand implements Command {
    private final int index;

    public UnmarkCommand(String indexString) {
        this.index = Integer.parseInt(indexString) - 1;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task taskToUnmark = taskList.getTask(index);
        taskToUnmark.markAsNotDone();

        ui.printBox("OK, I've marked this task as not done yet:\n  " + taskToUnmark);
    }
}