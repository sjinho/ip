public class Parser {



    public static Command parse(String input) {

        String trimmedInput = input.trim();

        String[] parts = trimmedInput.split(" ", 2);

        String commandWord = parts[0];

        switch (commandWord) {

            case "bye":

                return new ByeCommand();

            case "list":

                return new ListCommand();

            case "mark":

                return new MarkCommand(parts[1]);

            case "unmark":

                return new UnmarkCommand(parts[1]);

            case "todo":

                return new TodoCommand(parts[1]);

            case "deadline": {

                String deadLineArg = parts[1];

                String[] deadlineParts = deadLineArg.split(" /by ");

                return new DeadlineCommand(deadlineParts[0].trim(), deadlineParts[1].trim());

            }

            case "event": {

                String eventArgs = parts[1];

                String[] fromParts = eventArgs.split(" /from ", 2);

                String[] toParts = fromParts[1].split(" /to ", 2);

                return new EventCommand(fromParts[0].trim(), toParts[0].trim(), toParts[1].trim());

            }

            default:
                return new AddCommand(parts[0]);
        }

    }

}