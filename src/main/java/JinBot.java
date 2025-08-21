import java.util.Scanner;

public class JinBot {
    public static final String SPACING = "        ";

    public static final String INDENTATION = "  ";

    public static final String HORIZONTAL_LINE =
            SPACING + "______________________________________________________";

    public static final String GREET =
            "Hello! I'm JinBot\n" + SPACING + INDENTATION + "What can I do for you?";

    public static void printMessageBlock(String response) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(SPACING + INDENTATION + response);
        System.out.println(HORIZONTAL_LINE);
    }

    public static void main(String[] args) {
        printMessageBlock(GREET);
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("bye")) {
                printMessageBlock("Bye. Hope to see you again soon!");
                break;
            }

            if (userInput.equals("list")) {
                int size =  taskList.getSize();

                if (taskList.isEmpty()) {
                    printMessageBlock("There are no tasks in your list!");
                } else {
                    System.out.println(HORIZONTAL_LINE);
                    for (int i = 0; i < size; i++) {
                        System.out.println(SPACING + INDENTATION + (i+1) + ". " + taskList.getTask(i));
                    }
                    System.out.println(HORIZONTAL_LINE);
                }
            } else {
                taskList.addTask(userInput);
                printMessageBlock("Added: " + userInput);
            }
        }
    }
}
