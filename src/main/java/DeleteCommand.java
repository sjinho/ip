public class DeleteCommand implements Command {
    private final int index;

    public DeleteCommand(String indexStr) throws JinBotException {
        try {
            this.index = Integer.parseInt(indexStr) - 1;
        } catch (NumberFormatException e) {
            throw new JinBotException("Error! Task number must be a valid integer.");
        }
    }

    @Override
    public void execute(Ui ui, TaskList taskList) {
        Task removed = taskList.removeTask(index);
        ui.printBox("Noted. I've removed this task:\n  " + removed
                + "\nNow you have " + taskList.getSize() + " tasks in the list.");
    }
}
