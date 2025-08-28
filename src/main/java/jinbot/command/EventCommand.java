package jinbot.command;

import jinbot.task.Event;
import jinbot.ui.Ui;
import jinbot.task.Task;
import jinbot.task.TaskList;

import java.time.LocalDate;

public class EventCommand implements Command {
    private final String description;
    private final LocalDate from;
    private final LocalDate to;

    public EventCommand(String description, LocalDate from, LocalDate to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task event = new Event(description, from, to);
        taskList.addTask(event);

        ui.printBox("Got it. I've added this task:\n  " + event
            + "\nNow you have " + taskList.getSize()
            + " tasks in the list.");
    }
}