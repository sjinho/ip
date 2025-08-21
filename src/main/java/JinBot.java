import java.util.Scanner;

public class JinBot {
    private static final String SPACING = "        ";

    private static final String INDENTATION = "  ";

    private static final String HORIZONTAL_LINE =
            SPACING + "______________________________________________________";

    private static final String GREET =
            "Hello! I'm JinBot\n" + SPACING + INDENTATION + "What can I do for you?";

    public static void printMessageBlock(String response) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(SPACING + INDENTATION + response);
        System.out.println(HORIZONTAL_LINE);
    }

    public static void main(String[] args) {
        JinBot.printMessageBlock(GREET);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("bye")) {
                JinBot.printMessageBlock("Bye. Hope to see you again soon!");
                break;
            }

            JinBot.printMessageBlock(userInput);
        }
    }
}
