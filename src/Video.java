import java.io.File;
import java.net.URI;

/**
 * Video represents a video file on social media and is a subclass of {@link MediaItem}.
 * All Videos have a {@code File} containing the video file.
 * {@code URI} is accessed with {@link Video#toURI() toURI()}.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
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
    
    @Override
    public String toString() {
        return super.toString() +
               "<video width='300' autoplay><source src='" + vid.toURI() +   
               "' type='video/mp4' />" + "Your browser does not support the video element.</video>";
    }
}
