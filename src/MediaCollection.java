import java.util.HashMap;

/**
 * MediaCollection contains each {@link Topic Topic's} corresponding {@link MediaItem}, which is stored in a {@code HashMap}.
 * 
 * @author Saadat Emilbekova, Dylan Jablonski, Jason Mele
 * @version 4/9/2025
 */
public class MediaCollection {
    private HashMap<Topic, MediaItem> media = new HashMap<>();

    public MediaCollection() {
        this.media.put(Topic.Bacon, new Image("Bacon", "a slice", "assets/bacon.jpg"));
        this.media.put(Topic.Barbies, new Image("Today's Barbie", "Computer Programmer\nBarbie and Robotics\nEngineer Barbie", "assets/barbie.jpg"));
        this.media.put(Topic.Doritos, new Ad("Eat Chip", "Yummy Doritos", "https://www.doritos.com/"));
        this.media.put(Topic.Grapes, new Event("WE ARE EATING GRAPES", "Come eat grapes with us!", "Rowan University", "2025-01-12"));
        this.media.put(Topic.Hairstyles, new Image("Cool NEW Hairstyles", "How beautiful!!!!", "assets/hairstyles.jpg"));
        this.media.put(Topic.Hamsters, new Song("Hampster Dance", "Look at the little guy go!", "assets/HamsterDance.wav", "Hampton and the Hamsters"));
        this.media.put(Topic.Investments, new Ad("INVEST TODAY!!!!!!!!!!!!!!!!!!!!!!!!!", "Don't die poor, choose Charles Schwab.", "https://www.schwab.com/"));
        this.media.put(Topic.Music, new Song("Bad Romance", "Bad Romance is a song by American singer-songwriter Lady Gaga from her third extended play (EP), The Fame Monster (2009)—the reissue of her debut studio album, The Fame (2008)", "assets/BadRomance.wav", "Lady Gaga"));
        this.media.put(Topic.Pancakes, new Video("I'm Starving", "Please let me eat a pancake", "assets/Pancakes.mp4"));
        this.media.put(Topic.Pizza, new Event("Pizza Party!", "Entrance Fee: $15.37", "The Moon", "2137-01-01"));
        this.media.put(Topic.Popcorn, new Song("Popcorn Pop", "The Latest and Greatest", "assets/Popcorn.wav", "The Microwaves"));
        this.media.put(Topic.Romance, new Image("Love is like a thread <3", "Follow your heart!", "assets/Thread.jpg"));
        this.media.put(Topic.Squirrels, new Image("Look at him collect those leaves", "He's so cool", "assets/squirrel.png"));
        this.media.put(Topic.Sugar, new Song("Tasty Sugar", "Put me in ANYTHING", "assets/sugar.wav", "Minecraft Sugarcane Block"));
        this.media.put(Topic.Superman, new Event("Superman Celebration", "Mark you calendars!", "Superman Square, South Africa", "2020-06-11"));
        this.media.put(Topic.Toothpaste, new Video("Toothpaste", "Make brushing fun again", "assets/Toothpaste.mp4"));
        this.media.put(Topic.Travel, new Ad("Travel Today", "Choose Liberty Travel", "https://www.libertytravel.com/"));
        this.media.put(Topic.Volkswagons, new Ad("And if you run out of gas, it's easy to push", "What will Volkswagen think of next?", "https://www.vw.com/en.html"));
        this.media.put(Topic.Yachts, new Image("Epic Yachts", "The coolest and best", "assets/yacht.jpg"));
    }

    public HashMap<Topic, MediaItem> getMedia() {
        return media;
    }
}
