import java.net.URI;
import java.net.URL;

public class Ad extends MediaItem {
    private URL url;

    public Ad(String title, String description, String url_path) {
        super(title, description);

        try {
            this.url = new URI(url_path).toURL();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public URL getURL() {
        return this.url;
    }
}