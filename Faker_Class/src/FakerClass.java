import com.github.javafaker.Faker;

public class FakerClass {
	public static void main(String[] args) {

		Faker faker = new Faker();

		// Generate and print various types of fake data
		System.out.println("Name: " + faker.name().fullName());
		System.out.println("Username: " + faker.name().username());
		System.out.println("Email: " + faker.internet().emailAddress());
		System.out.println("Address: " + faker.address().fullAddress());
		System.out.println("Phone Number: " + faker.phoneNumber().phoneNumber());
		System.out.println("Company Name: " + faker.company().name());
		System.out.println("Job Title: " + faker.job().title());
		System.out.println("Lorem Ipsum Text: " + faker.lorem().paragraph());
		System.out.println("Random Number: " + faker.number().randomNumber());
		System.out.println("Random Double: " + faker.number().randomDouble(2, 1, 100));
		System.out.println("Date of Birth: " + faker.date().birthday().toString());

	}
}
