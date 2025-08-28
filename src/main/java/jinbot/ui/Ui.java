package jinbot.ui;

import java.util.Scanner;

public class Ui {
    private static final String SPACING = "        ";
    private static final String INDENTATION = "  ";
    private static final String HORIZONTAL_LINE = SPACING + "______________________________________________________";
    private static final String GREET = "Hello! I'm jinbot.JinBot\nWhat can I do for you?";
    private static final String GOODBYE = "Bye. Hope to see you again soon!";

    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showGreeting() {
        printBox(GREET);

    }
    public void showGoodbye() {
        printBox(GOODBYE);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void printBox(String message) {
        System.out.println(HORIZONTAL_LINE);
        for (String line : message.split("\\R")) {
            System.out.println(SPACING + INDENTATION + line);
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
