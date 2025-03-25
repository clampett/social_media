
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * A helper class that will generate a list of Posts using random generation of
 * post authors, post titles, and post texts.
 * 
 * @author Jack Myers
 */
public class PostGenerator {
	
	/**
	 * Generates a specified number of posts and returns them in an ArrayList.
	 * For testing purposes, this method will always include a post about 
	 * Cool Ranch Doritos.
	 * 
	 * @param numberOfPosts			the number of posts to generate
	 * @return						an ArrayList containing the generated posts
	 */
	public static ArrayList<Post> generatePosts(int numberOfPosts) {
		ArrayList<Post> samplePosts = new ArrayList<Post>(); 
		for (int i = 0; i < numberOfPosts/2; i++) {
			samplePosts.add(makePost());
		}
		samplePosts.add(new Post("Cool Ranch Doritos rock!", "Jay Lennon", "These Doritos are so much better than regular."));
		for (int i = numberOfPosts/2; i < numberOfPosts-1; i++) {
			samplePosts.add(makePost());
		}
		return samplePosts;		
	}

	/**
	 * A method to create a Post and populate its instance variables.  It uses
	 * an Entry to tie together the post title and topic.
	 * 
	 * @return		a sample Post
	 */
	private static Post makePost() {
		Post samplePost = new Post();
		samplePost.setAuthor(generateAuthor());
		Entry<String, String> randomPost = getPostEntry();
		samplePost.setTitle(randomPost.getKey());
		samplePost.setText(randomPost.getValue());
		return samplePost;
	}

	private static String generateAuthor() {
		String[] firstNames = {"Amber", "Bill", "Cherise", "Derek", "Eduardo", "Fahdi", "Gwen", 
				               "Harry", "Ivy", "Joan", "Ken", "Latisha", "Maurice", "Ned", 
				               "Olivia", "Pranesh", "Quentin", "Ralph", "Sasha", "Tucker", 
				               "Ursula", "Veronica", "Walt", "Xavier", "Yvette", "Zander"};
		String[] lastNames = { "Andrews", "Baker", "Collins", "Douglas", "Emerson", "Fallon",
				               "Graziano", "Harrison", "Illwitch", "Johnson", "Kent", 
				               "Lewis", "Moore", "Nadler", "O'Shaughnessy", "Patel",
				               "Peterson", "Ridinger", "Smith", "Tiu", "Tennyson", 
				               "Vanderbilt", "Williams", "Walton", "Young", "Chen" };
		int fIndex = (int) (Math.random() * firstNames.length);
		int lIndex = (int) (Math.random() * lastNames.length);
		return firstNames[fIndex] + " " + lastNames[lIndex];
	}
	
	/**
	 * This method returns an Entry object with the key of the title and the value
	 * of the text.  An interesting example of reusing the Java interface Entry.  Since
	 * an instance of an interface cannot be instantiated, a Java inner class was used 
	 * that implemented the Entry interface.  An object of that inner class (also called
	 * Entry) was created.
	 * 
	 * The text is generated from some standard phrases with the word BLANK.  The
	 * word BLANK will then be replaced by a value of the enum Topic.
	 * 
	 * @return		An Entry, i.e., an instance of our inner class, which is not known 
	 * 				to the method header, and hence the return type is identified as 
	 *              the generic X
	 */
	private static Entry<String, String> getPostEntry() {
		String[] quotes = {"For a long time I've been thinking about BLANK.",
				           "This situation about BLANK is getting out of hand.",
				           "None of my friends find anything amusing lately about BLANK.",
				           "Shouldn't everyone be more aware of BLANK?",
				           "It's been such a long day, and I can't handle much talk on BLANK.",
				           "I've just been researching BLANK.",
				           "I had a dream about BLANK last night.  BLANK! What do you think this could mean?",
				           "BLANK, BLANK, and BLANK.  That is all.  Peace out.",
				           "I wish I had more experience with BLANK!",
				           "Hoping someone buys me BLANK for my birthday.",
				           "Grandma just got back from vaction, and she bought the entire family BLANK as souveneirs!",
				           "Our country, reportedly, has lots of BLANK issues.",
				           "It would be really great if all people could agree about BLANK.",
				           "Hey everyone!  What's your favorite thing about BLANK?",
				           "I just can't get enough of BLANK.",
				           "BLANK smells so wonderful.  Doncha think?",
				           "BLANK!  Can't we chat about something else entirely?",
				           "I'm hoping that Melissa McCarthy will star in a BLANK movie soon.",
				           "Every day, I have to deal with BLANK!  And I'm sick and tired of it.",
				           "Anyone know any good songs about BLANK?",
				           "How can anyone understand much about BLANK without getting a doctorate degree?",
				           "Let's organize a big picnic, where we can all reminisce about BLANK.",
				           "I like small BLANK and large BLANK -- in equal measure."};
		int qIndex = (int) (Math.random() * quotes.length);
		int tIndex = (int) (Math.random() * Topic.values().length);
		
		/** An inner class which implements the interface Entry (from maps)
		 * 
		 * @author Jack Myers
		 *
		 * @param <K>	the key
		 * @param <V>	the value
		 */
		class PostEntry<K, V> implements Entry<K, V> {
			    private K key;
			    private V value;

			    /** Constructor
			     * 
			     * @param key		the key to use
			     * @param value		the value to use
			     */
				public PostEntry(K key, V value) {
			        this.key = key;
			        this.value = value;
			    }

				@Override
				public K getKey() {
					return key;
				}

				@Override
				public V getValue() {
					return value;
				}

				@Override
				public V setValue(V value) {
					V old = this.value;
			        this.value = value;
			        return old;
			    }
		}
		
		// Get random topic from enum
		String topic = Topic.values()[tIndex].name();
		int i = (int) (Math.random() * 3);
		String[] titlePhrases = { "Thoughts on " + topic,
				                  topic + " musings",
				                  "On " + topic};
		

		PostEntry<String, String> postEntry = 
				new PostEntry<>(titlePhrases[i], replaceBLANK(quotes[qIndex], topic));
		return postEntry;

		}

	/**
	 * Accepts a string with the characters "BLANK" and replaces the blank with
	 * the topic of the sentence.
	 * 
	 * @param s			the string containing "BLANK"
	 * @param topic		the string that should replace BLANK in the sentence
	 * @return			the string where BLANK is replaced
	 */
	private static String replaceBLANK(String s, String topic) {
		return s.replace("BLANK", topic);
	}
}
