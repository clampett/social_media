import java.io.File;
import java.net.URI;

/**
 * Image represents an image on social media and is a subclass of {@link MediaItem}.
 * All Images have a {@code File} containing the an image.
 * {@code URI} is accessed with {@link Image#toURI() toURI()}.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
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

    @Override
    public String toString() {
        return "<h2>" + super.getTitle() + "</h2>" +
               "<figure><img src='" + img.toURI() + "' />" + 
               "<figcaption>" + super.getDescription() + "</figcaption></figure>";
    }
}
