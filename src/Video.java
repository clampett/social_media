import java.io.File;

public class Video extends MediaItem {
    private File vid;

    public Video(String title, String description, String vid_path) {
        super(title, description);
        this.vid = new File(vid_path);
    }

    public File getFile() {
        return this.vid;
    }
}
