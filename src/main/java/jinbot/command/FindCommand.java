package jinbot.command;

import jinbot.task.Task;
import jinbot.task.TaskList;
import jinbot.ui.Ui;

/**
 * Represents a command to find tasks in the task list which description
 * contains a given keyword (case-insensitive).
 */
public class FindCommand implements Command {
    private final String keyword;

    /**
     * Creates a FindCommand with the specified keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching through the given task list.
     * Tasks which descriptions contain the keyword (case-insensitive)
     * are displayed in a numbered list. If no tasks match, a message is shown.
     *
     * @param ui       The UI instance used to interact with the user.
     * @param taskList The task list to search within.
     */
    @Override
    public void execute(Ui ui, TaskList taskList) {
        StringBuilder resultBuilder = new StringBuilder();
        int matchCount = 0;

        for (int i = 0; i < taskList.getSize(); i++) {
            Task task = taskList.getTask(i);
            if (task.getTaskName().toLowerCase().contains(keyword.toLowerCase())) {
                resultBuilder.append(matchCount + 1).append(". ").append(task).append("\n");
                matchCount++;
            }
        }

        if (matchCount == 0) {
            ui.printBox("No matching tasks found for: " + keyword);
        } else {
            String result = resultBuilder.toString().trim();
            ui.printBox("Here are the matching tasks in your list:\n" + result);
        }
    }
}
