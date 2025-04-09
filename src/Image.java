import java.io.File;
import java.net.URI;

public class Image extends MediaItem {
    private File img;

    public Image(String title, String description, String img_path) {
        super(title, description);
        img = new File(img_path);
    }

    public File getFile() {
        return this.img;
    }

    public URI toURI() {
        return this.img.toURI();
    }
}
