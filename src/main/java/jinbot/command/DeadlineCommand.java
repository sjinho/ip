package jinbot.command;

import jinbot.ui.Ui;
import jinbot.task.Task;
import jinbot.task.TaskList;
import jinbot.task.Deadline;

import java.time.LocalDate;

public class DeadlineCommand implements Command {
    private final String description;
    private final LocalDate by;

    public DeadlineCommand(String description, LocalDate by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task deadline = new Deadline(description, by);
        taskList.addTask(deadline);

        ui.printBox("Got it. I've added this task:\n  " + deadline
            + "\nNow you have " + taskList.getSize()
            + " tasks in the list.");
    }
}