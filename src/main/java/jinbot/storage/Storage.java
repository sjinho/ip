package jinbot.storage;

import jinbot.task.Todo;
import jinbot.task.Deadline;
import jinbot.task.Event;
import jinbot.task.Task;
import jinbot.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to disk using a simple line format.
 * Example lines:
 * T | 1 | read book
 * D | 0 | return book | Sunday
 * E | 0 | project meeting | Mon 2pm | 4pm
 */
public class Storage {
    private static final String DATA_DIR = "data";
    private static final String FILE_NAME = "jinbot.txt";

    /** 
     * Parses a single save-line into a jinbot.task.Task.
     */
    private Task parseLineToTask(String line) {
        // Split on: optional spaces, literal '|', optional spaces
        String[] p = line.split("\\s*\\|\\s*");
        if (p.length < 3) {
            throw new IllegalArgumentException("Corrupted line: " + line);
        }

        String type = p[0];
        boolean done = "1".equals(p[1]);

        Task task;
        switch (type) {
        case "T":
            // T | done | description
            task = new Todo(p[2]);
            break;
        case "D":
            // D | done | description | by
            if (p.length != 4) {
                throw new IllegalArgumentException("Corrupted deadline: " + line);
            }
            try {
                LocalDate by = LocalDate.parse(p[3]);
                task = new Deadline(p[2], by);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Corrupted deadline date: " + p[3]);
            }
            break;

        case "E":
            // E | done | description | from-to
            if (p.length < 4) {
                throw new IllegalArgumentException("Corrupted event: " + line);
            }
            String[] fromTo = p[3].split("\\s*~\\s*");

            try {
                LocalDate from = LocalDate.parse(fromTo[0].trim());
                LocalDate to = LocalDate.parse(fromTo[1].trim());
                task = new Event(p[2], from, to);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Corrupted event dates: " + p[3]);
            }
            break;

        default:
            throw new IllegalArgumentException("Bad type: " + type);
        }

        if (done) {
            task.markAsDone();
        }
        return task;
    }

    public List<Task> loadTasks() {
        List<Task> loadedTasks = new ArrayList<>();

        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(DATA_DIR, FILE_NAME);
        try {
            if (file.createNewFile()) {
                return loadedTasks;
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        continue;
                    }
                    try {
                        Task loadedTask = parseLineToTask(line);
                        loadedTasks.add(loadedTask);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Skipping invalid line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while loading tasks: " + e.getMessage());
        }

        return loadedTasks;
    }

    public void saveTasks(TaskList tasks) {
        File file = new File(DATA_DIR, FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < tasks.getSize(); i++) {
                Task task = tasks.getTask(i);
                fileWriter.write(task.toSaveFormat());
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }
}
