package jinbot.command;

import jinbot.task.Todo;
import jinbot.ui.Ui;
import jinbot.task.Task;
import jinbot.task.TaskList;

public class TodoCommand implements Command {
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task todo = new Todo(description);
        taskList.addTask(todo);

        ui.printBox("Got it. I've added this task:\n  " + todo
                + "\nNow you have " + taskList.getSize() + " tasks in the list.");
    }
}