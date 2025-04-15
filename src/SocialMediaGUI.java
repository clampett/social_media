import java.time.LocalTime;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * SocialMediaGUI simulates a social media platform, with both written and media posts simulated.
 * Written posts are randomized, while media posts are based upon the most discussed {@link Topic}
 * in the the written posts.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/15/2025
 * @see MediaItem MediaItem - a super class of all media posts
 * @see Post Post - written posts to be randomized
 */
public class SocialMediaGUI extends Application {

    private WebView postFeed = new WebView();
    private WebView mediaFeed = new WebView();

    private WebEngine postEngine = postFeed.getEngine();
    private WebEngine mediaEngine = mediaFeed.getEngine();

    private Label lblStatus = new Label("Post Feed Not Started...");
    private Label lblMedia = new Label("Media Feed Not Started...");

    private static final int NUMBER_OF_POSTS = 12;
    private String lastTopic = "";  

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage mainStage) {
        HBox root = new HBox();
        styleMainPane(root);
        setupControls(root);
        Scene scene = new Scene(root, 600, 800);
        setStage(mainStage, scene);
    }

    /**
     * Stylizes the supplied pane
     * 
     * @param root Layout Pane to style
     */
    private void styleMainPane(Pane root) {
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-background-color: aliceblue");
    }

    /**
     * Sets up the user controls
     * 
     * @param mainPane Layout pane to add controls to
     */
    private void setupControls(Pane mainPane) {
        postFeed.setPrefHeight(800);
        postFeed.setPrefWidth(400);
        mediaFeed.setPrefHeight(800);
        mediaFeed.setPrefWidth(400);

        postEngine.setUserStyleSheetLocation("data:,body { font: 10px Arial; }");

        lblStatus.setMinHeight(30);
        lblMedia.setMinHeight(30);

        Button btnStart = new Button("Start");
        Button btnClear = new Button("Clear");
        Button btnExit = new Button("Exit");
        Button btnShowMedia = new Button("Show Media");

        btnStart.setOnAction(event -> startFeed());
        btnClear.setOnAction(event -> {
            postEngine.loadContent("");
            lastTopic = "";
        });
        btnExit.setOnAction(event -> Platform.exit());
        btnShowMedia.setOnAction(event -> startMediaFeed());

        HBox buttonBox = new HBox(5, btnStart, btnClear, btnExit);
        VBox postBox = new VBox(5, lblStatus, buttonBox, postFeed);
        VBox mediaBox = new VBox(5, lblMedia, btnShowMedia, mediaFeed);

        mainPane.getChildren().addAll(postBox, mediaBox);
    }

    /**
     * Sets the supplied {@code Stage} to the supplied {@code Scene}
     * 
     * @param mainStage {@code Stage} to be set
     * @param scene {@code Scene} to be shown
     */
    private void setStage(Stage mainStage, Scene scene) {
        mainStage.setTitle("A Social Media Simulation");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     * Creates and runs {@link SocialMediaGUI#runTaskToSimulatePosts() runTaskToSimulatePosts()} on a new {@code Thread}
     */
    private void startFeed() {
        Runnable task = this::runTaskToSimulatePosts;
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    /**
     * Simulates posts being made on a social media platform.
     * @see PostGenerator
     * @see Post
     */
    private void runTaskToSimulatePosts() {
        ArrayList<Post> samplePosts = PostGenerator.generatePosts(NUMBER_OF_POSTS);
        for (int i = 0; i < NUMBER_OF_POSTS; i++) {
            try {
                String status = "Getting post " + (i + 1) + " of " + NUMBER_OF_POSTS +
                        " in thread " + Thread.currentThread().getName();
                Post samplePost = samplePosts.get(i);

                Platform.runLater(() -> {
                    lblStatus.setText(status);
                    String currentHTML = (String) postEngine.executeScript("document.body.innerHTML");
                    postEngine.loadContent("<html><body>" + currentHTML + samplePost + "</body></html>");
                });

                Thread.sleep(2000 + (int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates and runs {@link SocialMediaGUI#runMediaFeedTask() runMediaFeedTask()} on a new {@code Thread}
     */    
    private void startMediaFeed() {
        Runnable mediaTask = this::runMediaFeedTask;
        Thread mediaThread = new Thread(mediaTask);
        mediaThread.setDaemon(true);
        mediaThread.start();
    }

    /**
     * A loop to manage the timing and count of the number of {@link MediaItem MediaItems} displayed
     */
    private void runMediaFeedTask() {
        int i = 0;
        while (i < NUMBER_OF_POSTS * (5 / 4)) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            updateMediaFeed(++i);
        }
    }

    /**
     * Simulates the media being posted on a social media platform.
     * It will check the posts and find the most talked about subject. It will then display
     * media related to that subject.
     * 
     * @param count current number of {@link MediaItem MediaItems} displayed
     */
    private void updateMediaFeed(int count) {
        String status = "Getting media " + count + " in thread " + Thread.currentThread().getName();
        MediaCollection mc = new MediaCollection();

        Platform.runLater(() -> {
            String postHTML = (String) postEngine.executeScript("document.documentElement.outerHTML");
            String mostUsed = Tokenizer.mostUsedTopic(postHTML);

            if (!mostUsed.equals("nothing was found") && !mostUsed.equals(lastTopic)) {
                try {
                    MediaItem item = mc.getMedia().get(Topic.valueOf(mostUsed));
                    String mediaContent = item.toString() +
                            "<hr><span style='font-size: x-small;'>" + LocalTime.now() + "</span><hr />";
                    mediaEngine.loadContent("<html><body>" + mediaContent + "</body></html>");
                    lblMedia.setText(status);
                    lastTopic = mostUsed;
                } catch (Exception e) {
                    System.out.println(" Could not load media for: " + mostUsed);
                }
            }
        });
    }
}