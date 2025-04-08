public class Driver 
{
	public static void main(String[] args) {
		//System.out.println(Tokenizer.mostUsedWord("On Superman - Ursula Ridinger\r\n" + 
		//		"It's been such a long day, and I can't handle much talk on Superman."));
		String s  = "<html><body><span color='red'>Musings on sex and muscles</span>";
		s = s.toLowerCase();
		s = Tokenizer.removeHTMLtags(s);
		s = Tokenizer.removeStopWords(s);


		System.out.println(Tokenizer.countTargetWords("hello hello goodbye", "godbye"));
		System.out.println(Tokenizer.mostUsedTopic("DoritosDoritosBaconBaconBacon"));
	}
}
