import java.util.Scanner;

public class JinBot {
    private final Ui ui;
    private final TaskList taskList;

    public JinBot() {
        this.ui = new Ui();
        this.taskList = new TaskList();
    }

    public void run() {
        ui.showGreeting();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            CommandType command = Parser.perse(userInput);

            switch (command) {
                case BYE:
                    ui.showGoodbye();
                    return;

                case LIST:
                    ui.printBox("Here are the tasks in your list:\n" + taskList.toNumberedListItems());
                    break;

                case MARK:
                    int index_mark = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    Task task_mark = taskList.getTask(index_mark);
                    task_mark.markAsDone();
                    ui.printBox("Nice! I've marked this task as done:\n  [X] " + task_mark.getTaskName());
                    break;

                case UNMARK:
                    int index_unmark = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    Task task_unmark = taskList.getTask(index_unmark);
                    task_unmark.markAsNotDone();
                    ui.printBox("OK, I've marked this task as not done yet:\n  [ ] " + task_unmark.getTaskName());
                    break;

                case ADD:
                    taskList.addTask(userInput);
                    ui.printBox("Added: " + userInput);
                    break;

                default:
                    ui.printBox("Sorry, I don't understand that command.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new JinBot().run();
    }
}
