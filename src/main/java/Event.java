import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event extends Task {
    private final LocalDate from;
    private final LocalDate to;

    public Event(String description, LocalDate from, LocalDate to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (getisDone() ? "1" : "0")
            + " | " + getTaskName()
            + " | " + from.toString() + " ~ " + to.toString();
    }

    @Override public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return "[E]" + super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }
}