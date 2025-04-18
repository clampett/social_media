import java.io.File;
import java.net.URI;

/**
 * Song represents a playable music file on social media and is a subclass of {@link MediaItem}.
 * All Songs have {@code File} containing the music file.
 * {@code URI} is accessed with {@link Song#toURI() toURI()}.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
public class Song extends MediaItem {
    private File sng;
    private String artist;

    public Song(String title, String description, String sng_path, String artist) {
        super(title, description);
        this.sng = new File(sng_path);
        this.artist = artist;
    }

    public File getFile() {
        return this.sng;
    }

    public String getArtist() {
        return this.artist;
    }

    public URI toURI() {
        return this.sng.toURI();
    }

    @Override
    public String toString() {
        return super.toString() +
               "<audio controls autoplay><source src='" + sng.toURI() +   
               "' type='audio/mp3' />" + "Your browser does not support the audio element.</audio>" + "by " + artist; 
    }
}
