public class Parser {

    public static Command parse(String input) throws JinBotException {
        String trimmedInput = input.trim();

        if (trimmedInput.isEmpty()) {
            throw new JinBotException("Error! Empty input!");
        }

        String[] parts = trimmedInput.split(" ", 2);
        String commandWord = parts[0];

        switch (commandWord) {
            case "bye":
                return new ByeCommand();

            case "list":
                return new ListCommand();

            case "mark":
                if (parts.length < 2) {
                    throw new JinBotException("Error! Provide a task number to mark.");
                }
                return new MarkCommand(parts[1]);

            case "unmark":
                if (parts.length < 2) {
                    throw new JinBotException("Error! Provide a task number to unmark.");
                }
                return new UnmarkCommand(parts[1]);

            case "todo":
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    throw new JinBotException("Error! Description of a todo cannot be empty.");
                }
                return new TodoCommand(parts[1].trim());

            case "deadline": {
                if (parts.length < 2) {
                    throw new JinBotException("Error! Description of a deadline cannot be empty.");
                }
                String[] deadlineParts = parts[1].split(" /by ", 2);
                if (deadlineParts.length < 2) {
                    throw new JinBotException("Error! Needs a description and a /by time.");
                }
                return new DeadlineCommand(deadlineParts[0].trim(), deadlineParts[1].trim());
            }

            case "event": {
                if (parts.length < 2) {
                    throw new JinBotException("Error! Description of an event cannot be empty.");
                }
                String[] fromParts = parts[1].split(" /from ", 2);
                if (fromParts.length < 2) {
                    throw new JinBotException("Error! Needs a description and a /from time.");
                }
                String[] toParts = fromParts[1].split(" /to ", 2);
                if (toParts.length < 2) {
                    throw new JinBotException("Error! Needs both /from and /to times.");
                }
                return new EventCommand(fromParts[0].trim(), toParts[0].trim(), toParts[1].trim());
            }

            default:
                throw new JinBotException("Error! I don't understand that command word: " + commandWord);
        }
    }
}
