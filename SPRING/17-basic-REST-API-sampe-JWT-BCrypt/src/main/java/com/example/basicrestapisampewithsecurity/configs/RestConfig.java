package com.example.basicrestapisampewithsecurity.configs;

import org.springframework.context.annotation.Configuration;

//import java.util.Random;

/**
 * Configuration class for setting up additional configurations in the application.
 */
@Configuration
public class RestConfig {

//    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);
//    private static final Faker fakeData = new Faker();
//
//    /**
//     * CommandLineRunner bean for initializing sample data in the BookRepository.
//     *
//     * @param book The BookRepository to initialize with sample data.
//     * @return A CommandLineRunner for data initialization.
//     */
//    @Bean
//    CommandLineRunner initData(BookRepository book) {
//        return args -> {
//
//            // Generate and save 100 random books to the BookRepository
//            for (int i = 0; i < 100; i++) {
//                Book bookA = new Book(fakeData.book().author(),
//                        fakeData.book().title(),
//                        fakeData.code().isbn13(),
//                        new Random().nextInt(1900, 2025));
//
//                book.save(bookA);
//            }
//
//            // Log a message indicating that data has been saved successfully
//            logger.info("Data saved to DB successfully!!! <---");
//
//        };
//    }

}
