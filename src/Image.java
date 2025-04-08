import java.io.File;

public class Image extends MediaItem {
    private File img;

    public Image(String title, String description, String img_path) {
        super(title, description);
        img = new File(img_path);
    }

    public File getFile() {
        return this.img;
    }
}
