
import java.util.HashMap;
import java.util.Map.Entry;
/**
 * A helper class to deal with String analysis by either tokenizing a String or
 * extracting tokens from a String.
 * 
 * @author Jack Myers
 *
 */
public class Tokenizer {
	
	/**
	 * An array of "stop words."  These are words that should not be counted when
	 * searching or analyzing a String.  Currently not used, but possibly valuable
	 * in the future for other projects.
	 */
	public static String[] stopwords = 
		{ "on","thoughts", "musings", "and", "about", "of", "i" };
	
	/**
	 * This method takes in a String (which could be a very long String) and
	 * builds a HashMap to store the analyzed results.  The key of the HashMap will
	 * be a value of the enum Topic.  The value of the HashMap will be the count of
	 * how many times the word appears in the input string.
	 * 
	 * @param inputString	the String to analyze
	 * @return				the value of the Topic enum with the highest count.
	 * 						(Note: in case of a tie, any value of the enum can be returned.)
	 * 
	 */
	public static String mostUsedTopic(String inputString) {
		// First lowercase the string
		inputString = inputString.toLowerCase();
		
		// Next remove HTML tags
		inputString = removeHTMLtags(inputString);
		
		// Now create the HashMap to store the analyzed results
		HashMap<String, Integer> topics = new HashMap<String, Integer>();

		// Loop through the values of the Topic enum and populate the HashMap
		for (Topic topic : Topic.values()) {
			topics.put(topic.name(), countTargetWords(inputString, topic.name().toLowerCase()));
		}
					
		Integer maxValue = 0;
		String maxKey = "nothing was found";
		for (Entry<String, Integer> entry : topics.entrySet()) {
			// Compare to the previous max value.  
			// If compareTo yields a positive number, the value is greater
			if (entry.getValue().compareTo(maxValue) > 0) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
			}
		}

		return maxKey;

	}
	
	/**
	 * This method takes in a string that contains HTML and will remove all HTML tags.
	 * An HTML tag begins with '<' and ends with '>'.  
	 * 
	 * For instance an HTML string that looks like:
	 * 
	 * 		<p>The <span style='font-color: red;'>red</span> dog is named <u>Clifford.</u></p>
	 * 
	 * will be converted to:
	 * 
	 * 		The red dog is named Clifford.
	 * 
	 * It does this by using regular expressions to identify all HTML tags and then
	 * using the String method replaceAll.
	 * 
	 * @param inputString		the HTML string to be converted
	 * @return					the HTML string stripped of its tags
	 */
	public static String removeHTMLtags(String inputString) {
		return inputString.replaceAll("(\\<.*?\\>|&lt;.*?&gt;)", " ");
	}
	
	/**
	 * Removes any stop words from a string. This method assumes that the stop words
	 * either begin with and end with a space.  In this way, the method will not remove
	 * stop word "on" from "bacon" or "onward".  Punctuation should have been removed
	 * from the input String before invoking this method.
	 * 
	 * Currently not used, but possibly valuable in the future for other projects.
	 * 
	 * @param inputString		the string to be excised
	 * @return					the string with all stop words replaced by spaces
	 */
	public static String removeStopWords(String inputString) {
		int i = 0;
		while (i < stopwords.length) {
			inputString = inputString.replaceAll(" " + stopwords[i] + " ", " "); 
			i++;
		}
		return inputString;
	}
	
	/**
	 * This method counts the number of occurrences of a String in another String
	 * It works based on splitting the input String into fragments based on the
	 * occurrence of the substring.  Using the split() method, it builds an array 
	 * based on the number of divisions of the input string. The number of divisions is
	 * equal to the number of occurrences.
	 * 
	 * @param inputString			the String to be analyzed for substrings
	 * @param stringToCount			the substring to search for in the input string
	 * @return						the number of occurences of the substring in the input string
	 */
	public static int countTargetWords(String inputString, String stringToCount) {
		return inputString.split(stringToCount, -1).length - 1;
	}
}
