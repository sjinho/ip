public class ListCommand implements Command {
    @Override
    public void execute(Ui ui, TaskList taskList) {
        String listOutput = taskList.toNumberedListItems();
        ui.printBox("Here are the tasks in your list:\n" + listOutput);
    }
}
