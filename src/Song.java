import java.io.File;

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
}
