import java.time.LocalDate;

/**
 * Event represents a public event on social media and is a subclass of {@link MediaItem}.
 * All Events have a location and a {@code LocalDate} date.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
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

    @Override
    public String toString() {
        return super.toString() +
               "<p>" + location + "\n" + date + "</p>";
    }
}
