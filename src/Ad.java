import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Ad represents an advertisement on social media and is a subclass of {@link MediaItem}.
 * All Ads include a {@code URL} to a website. 
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
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

    @Override
    public String toString() {
        try {
            return super.toString() + 
                "<a href='" + url.toURI() + "'>" + url + "</a>";
        } catch(URISyntaxException e) {
            e.printStackTrace();
            return "<p>" + url.toString() + "</p>";
        }
    }
}