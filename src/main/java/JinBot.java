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

            try {
                Command command = Parser.parse(userInput);
                command.execute(ui, taskList);

                if (command instanceof ByeCommand) {
                    return;
                }
            } catch (JinBotException e) {
                ui.printBox(e.getMessage());
            } catch (Exception e) {
                ui.printBox("Oops! Something went wrong. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new JinBot().run();
    }
}
