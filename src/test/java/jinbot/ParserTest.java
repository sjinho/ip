package jinbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jinbot.command.*;

public class ParserTest {
    @Test
    void parse_byeCommand_returnsByeCommand() throws JinBotException {
        Command c = Parser.parse("bye");
        assertEquals("ByeCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_listCommand_returnsListCommand() throws JinBotException {
        Command c = Parser.parse("list");
        assertEquals("ListCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_markCommand_returnsMarkCommand() throws JinBotException {
        Command c = Parser.parse("mark 1");
        assertEquals("MarkCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_unmarkCommand_returnsUnmarkCommand() throws JinBotException {
        Command c = Parser.parse("unmark 2");
        assertEquals("UnmarkCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_todoCommand_returnsTodoCommand() throws JinBotException {
        Command c = Parser.parse("todo read book");
        assertEquals("TodoCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_deadlineCommand_returnsDeadlineCommand() throws JinBotException {
        Command c = Parser.parse("deadline finish assignment /by 2025-12-31");
        assertEquals("DeadlineCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_eventCommand_returnsEventCommand() throws JinBotException {
        Command c = Parser.parse("event conference /from 2025-12-31 /to 2026-01-02");
        assertEquals("EventCommand", c.getClass().getSimpleName());
    }

    @Test
    void parse_deleteCommand_returnsDeleteCommand() throws JinBotException {
        Command c = Parser.parse("delete 3");
        assertEquals("DeleteCommand", c.getClass().getSimpleName());
    }
}