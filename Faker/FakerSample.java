import com.github.javafaker.Faker;

public class FakerSample {

	public static void main(String[] args) {
		
		/**
		 * GENERATES FAKE DATA. THIS IS JUST SOME SAMPLES.
		 */
        Faker faker = new Faker();

        // Generate a random job title
        String jobTitle = faker.job().title();
        System.out.println("Job Title: " + jobTitle);

        // Generate a random company name
        String companyName = faker.company().name();
        System.out.println("Company Name: " + companyName);

        // Generate a random sentence
        String sentence = faker.lorem().sentence();
        System.out.println("Sentence: " + sentence);

        // Generate a random date of birth
        String dateOfBirth = faker.date().birthday().toString();
        System.out.println("Date of Birth: " + dateOfBirth);

        // Generate a random credit card number
        String creditCardNumber = faker.finance().creditCard();
        System.out.println("Credit Card Number: " + creditCardNumber);

        // Generate a random color name
        String colorName = faker.color().name();
        System.out.println("Color Name: " + colorName);

        // Generate a random city
        String city = faker.address().city();
        System.out.println("City: " + city);

        // Generate a random book title
        String bookTitle = faker.book().title();
        System.out.println("Book Title: " + bookTitle);
        
        // Generate a random email address
        String email = faker.internet().emailAddress();
        System.out.println("Email: " + email);

        // Generate a random username
        String username = faker.name().username();
        System.out.println("Username: " + username);

        // Generate a random URL
        String url = faker.internet().url();
        System.out.println("URL: " + url);

        // Generate a random phone number (with a specific format)
        String formattedPhoneNumber = faker.phoneNumber().cellPhone();
        System.out.println("Formatted Phone Number: " + formattedPhoneNumber);

        // Generate a random country
        String country = faker.address().country();
        System.out.println("Country: " + country);

	}

}
