package tool.random.projects;

import java.util.Arrays;
import java.util.Optional;


public class App {
	
	public static void main(String[] args) {
		System.out.println(capitalizeText("kazkas kazkur kazkodel"));
		System.out.println(capitalizeText("kazkas kazkur"));
		System.out.println(capitalizeText("kazkas"));
	}

	public static String capitalizeText(String name) {
		if (name.contains(" ")) {
	        Optional<String> formattedText = Arrays.stream(name.split(" "))
						    .map(word -> Character.toUpperCase(word.charAt(0)) 
									 + word.substring(1))
						    .reduce((a, b) -> a + " " + b);
	        
	        return formattedText.orElse("");

		} else {
			String formattedText = Character.toUpperCase(name.charAt(0)) 
							 + name.substring(1);

			return formattedText;
		}	
	}

}
