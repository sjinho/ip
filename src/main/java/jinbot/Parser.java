package jinbot;

import jinbot.command.ByeCommand;
import jinbot.command.Command;
import jinbot.command.DeadlineCommand;
import jinbot.command.DeleteCommand;
import jinbot.command.EventCommand;
import jinbot.command.ListCommand;
import jinbot.command.MarkCommand;
import jinbot.command.TodoCommand;
import jinbot.command.UnmarkCommand;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Parses user input into executable Command objects.
 */
public class Parser {

    /**
     * Parses the given user input string and returns the corresponding Command.
     *
     * @param input The raw user input string.
     * @return The Command representing the user’s instruction.
     * @throws JinBotException If the input is empty, malformed, or contains an invalid command.
     */
    public static Command parse(String input) throws JinBotException {
        String trimmedInput = input.trim();
        LocalDate today = LocalDate.now();

        if (trimmedInput.isEmpty()) {
            throw new JinBotException("Error! Empty input!");
        }

        String[] parts = trimmedInput.split(" ", 2);
        String commandWord = parts[0];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        switch (commandWord) {
        case "bye":
            if (parts.length > 1) {
                throw new JinBotException("Error! Only write 'bye' to escape.");
            }

            return new ByeCommand();

        case "list":
            if (parts.length > 1) {
                throw new JinBotException("Error! Only write 'list' to list down your tasks");
            }

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

        case "deadline":
            if (parts.length < 2) {
                throw new JinBotException("Error! Description of a deadline cannot be empty.");
            }

            String[] deadlineParts = parts[1].split(" /by ", 2);

            if (deadlineParts.length < 2) {
                throw new JinBotException("Error! Needs a description and a /by time.");
            }

            String description = deadlineParts[0].trim();
            String byString = deadlineParts[1].trim();


            try {
                // Use the custom formatter to parse the date and time
                LocalDate by = LocalDate.parse(byString);

                if (by.isBefore(today)) {
                    throw new JinBotException(
                        "Error! The deadline date has already passed. "
                        + "Please enter a future date.");
                }

                return new DeadlineCommand(description, by);
            } catch (DateTimeParseException e) {
                try {
                    LocalDate by = LocalDate.parse(byString, formatter);
                    return new DeadlineCommand(description, by);
                } catch (DateTimeParseException e2) {
                    throw new JinBotException("Error! Invalid date and time format. Please use 'DD/MM/YYYY' or 'YYYY-MM-DD'.");
                }
            }

        case "event":
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

            String eventDescription = fromParts[0].trim();
            String fromString = toParts[0].trim();
            String toString = toParts[1].trim();

            try {
                LocalDate from = LocalDate.parse(fromString);
                LocalDate to = LocalDate.parse(toString);

                if (from.isBefore(today)) {
                    throw new JinBotException("Error! The event start date has already passed. Please enter today’s date or a future date.");
                }

                if (to.isBefore(from)) {
                    throw new JinBotException("Error! The event start date must be before the end date.");
                }

                return new EventCommand(eventDescription, from, to);
            } catch (DateTimeParseException e) {
                try {
                    LocalDate from = LocalDate.parse(fromString, formatter);
                    LocalDate to = LocalDate.parse(toString, formatter);
                    return new EventCommand(eventDescription, from, to);
                } catch (DateTimeParseException e2) {
                    throw new JinBotException("Error! Invalid date and time format for event. Please use 'DD/MM/YYYY' or YYYY-MM-DD'.");
                }
            }

        case "delete":
            if (parts.length < 2) {
                throw new JinBotException("Error! Provide a task number to delete.");
            }
            return new DeleteCommand(parts[1]);

        default:
            throw new JinBotException("Error! I don't understand that command word: " + commandWord);
        }
    }
}
