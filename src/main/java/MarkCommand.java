public class MarkCommand implements Command {
    private final int index;

    public MarkCommand(String indexString) {
        this.index = Integer.parseInt(indexString) - 1; // Convert to 0-based index
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task taskToMark = taskList.getTask(index);
        taskToMark.markAsDone();

        ui.printBox("Nice! I've marked this task as done:\n  " + taskToMark);
    }
}