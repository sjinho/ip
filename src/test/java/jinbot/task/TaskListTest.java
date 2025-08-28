package jinbot.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void addTask_correctlyIncreasesSize() {
        TaskList taskList = new TaskList();
        Task task1 = new Todo("test todo 1");

        assertEquals(0, taskList.getSize());
        taskList.addTask(task1);
        assertEquals(1, taskList.getSize());
    }

    @Test
    public void removeTask_correctlyDecreasesSize() {
        TaskList taskList = new TaskList();
        Task task1 = new Todo("test todo 1");
        Task task2 = new Todo("test todo 2");

        taskList.addTask(task1);
        taskList.addTask(task2);
        assertEquals(2, taskList.getSize());
        Task removedTask = taskList.removeTask(0);
        assertEquals(task1, removedTask);
        assertEquals(1, taskList.getSize());
    }

    @Test
    public void toNumberedListItems_emptyList_returnsNoTasksMessage() {
        TaskList taskList = new TaskList();

        String expected = "No tasks yet.";
        assertEquals(expected, taskList.toNumberedListItems());
    }

    @Test
    public void toNumberedListItems_singleItem_returnsCorrectFormat() {
        TaskList taskList = new TaskList();
        Task task1 = new Todo("test todo 1");

        taskList.addTask(task1);
        String expected = "1. [T][ ] test todo 1";
        assertEquals(expected, taskList.toNumberedListItems());
    }

    @Test
    public void toNumberedListItems_multipleItems_returnsCorrectFormat() {
        TaskList taskList = new TaskList();
        Task task1 = new Todo("test todo 1");
        Task task2 = new Todo("test todo 2");

        taskList.addTask(task1);
        taskList.addTask(task2);
        String expected = "1. [T][ ] test todo 1\n2. [T][ ] test todo 2";
        assertEquals(expected, taskList.toNumberedListItems());
    }
}
