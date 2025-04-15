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
        { "on", "thoughts", "musings", "and", "about", "of", "i" };

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
        inputString = inputString.toLowerCase();
        inputString = removeHTMLtags(inputString);

        HashMap<String, Integer> topics = new HashMap<>();
        for (Topic topic : Topic.values()) {
            topics.put(topic.name(), countTargetWords(inputString, topic.name().toLowerCase()));
        }

        String maxKey = "nothing was found";
        int maxValue = 0;
        for (Entry<String, Integer> entry : topics.entrySet()) {
            if (entry.getValue() > maxValue) {
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

        return inputString.split("\\b" + stringToCount + "\\b", -1).length - 1;
    }
}
