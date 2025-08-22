public class AddCommand implements Command {
    private final String description;

    public AddCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task task = new Task(description);
        taskList.addTask(task);

        ui.printBox("Added: " + task
                + "\nNow you have " + taskList.getSize() + " tasks in the list.");
    }
}