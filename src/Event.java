
import java.time.LocalDate;

public class Event extends MediaItem {
    private String location;
    private LocalDate date;

    public Event(String title, String description, String location, String date) {
        super(title, description);
        this.location = location;
        this.date = LocalDate.parse(date);
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }
}
