public class EventCommand implements Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task event = new Event(description, from, to);
        taskList.addTask(event);

        ui.printBox("Got it. I've added this task:\n  " + event
                + "\nNow you have " + taskList.getSize() + " tasks in the list.");
    }
}