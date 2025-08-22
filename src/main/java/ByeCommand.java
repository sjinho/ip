public class ByeCommand implements Command {
    @Override
    public void execute(Ui ui, TaskList taskList) {
        ui.showGoodbye();
    }
}
