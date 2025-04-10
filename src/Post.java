/**
 * A class to define a simple social media post
 * 
 * @author Jack Myers
 *
 */
public class Post {
	private String title;
	private String author;
	private String text;
	
	/**
	 * Full argument constructor
	 * 
	 * @param title		the title of the post
	 * @param author	the author of the post
	 * @param text		the text of the post
	 */
	public Post(String title, String author, String text) {
		this.title = title;
		this.author = author;
		this.text = text;
	}

	/**
	 * The no-argument constructor
	 */
	public Post() {
	}

	/**
	 * Standard getter
	 * 
	 * @return	the title of the post
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Standard getter
	 * 
	 * @return	the author of the post
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Standard getter
	 * 
	 * @return	the text of the post
	 */
	public String getText() {
		return text;
	}

	/**
	 * Standard setter
	 * 
	 * @param title		the title of the post
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Standard setter
	 * 
	 * @param author	the author of the post
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Standard setter
	 * 
	 * @param text		the text of the post
	 */
	public void setText(String text) {
		this.text = text;
	}

	/** 
	 * Returns an HTML string for proper formatting
	 */
	@Override
	public String toString() {
		return "<strong style='color:RoyalBlue;'>" + this.title + "</strong> - " +
	           "<em>" + this.author + "</em>" +
				"<p>" + this.text + "</p><hr />";
	}
}