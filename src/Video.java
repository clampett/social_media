import java.io.File;
import java.net.URI;

public class Video extends MediaItem {
    private File vid;

    public Video(String title, String description, String vid_path) {
        super(title, description);
        this.vid = new File(vid_path);
    }

    public File getFile() {
        return this.vid;
    }

    public URI toURI() {
        return this.vid.toURI();
    }
}
