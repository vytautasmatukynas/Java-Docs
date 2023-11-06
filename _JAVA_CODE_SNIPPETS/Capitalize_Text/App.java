import java.util.Arrays;
import java.util.Optional;


/**
 * Capitalize one word or sentence
 */

public class App {
	
	public static void main(String[] args) {
		System.out.println(capitalizeText("kazkas kazkur kazkodel"));
		System.out.println(capitalizeText("kazkas kazkur"));
		System.out.println(capitalizeText("kazkas"));
	}

	public static String capitalize(String name) {
		try {
			if (name.contains(" ")) {
				Optional<String> formattedText = Arrays.stream(name.split(" "))
						.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
						.reduce((a, b) -> a + " " + b);

				return formattedText.orElse("");

			} else {
				String formattedText = Character.toUpperCase(name.charAt(0)) + name.substring(1);

				return formattedText;
			}
		} catch (Exception e) {
			FileHandler.saveToFile(e.getMessage(), "errors/TextEditor_Errors.txt");
		}
		
		return "";
	}

}
