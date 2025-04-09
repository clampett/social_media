/**
 * MediaItem represents a form of media that can be displayed in a JavaFX {@code WebView}.
 * It is the abstract, superclass of a number of more specific media types.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
public abstract class MediaItem {
    private String title, description;

    public MediaItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }
}