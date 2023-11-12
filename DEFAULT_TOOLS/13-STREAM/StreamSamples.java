import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamSamples {
	
	public static void collectionToOptionalRemoveNull() {
		List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");

        List<String> nonNull = names.stream()
					                .map(Optional::ofNullable) // Wrap each element with an Optional
					                .filter(Optional::isPresent) // Filter out empty OPTIONALS (null values)
					                .map(Optional::get) // Unwrap the values from the OPTIONALS
					                .map(String::toUpperCase) // Convert to UPPERCASE or do ANYTHING ELSE
					                .toList();

        nonNull.forEach(System.out::println);
	}

}
