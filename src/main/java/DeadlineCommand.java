public class DeadlineCommand implements Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task deadline = new Deadline(description, by);
        taskList.addTask(deadline);

        ui.printBox("Got it. I've added this task:\n  " + deadline
                + "\nNow you have " + taskList.getSize() + " tasks in the list.");
    }
}