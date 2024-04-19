package com.example.basicrestapisample.configurations;

import com.example.basicrestapisample.models.Book;
import com.example.basicrestapisample.repositories.BookRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

//import java.util.Random;

@Configuration
public class RestConfig {

//    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);
//
//    private static final Faker fakeData = new Faker();
//
//    @Bean
//    CommandLineRunner initData(BookRepository book) {
//        return args -> {
//
//            for ( int i = 0 ; i < 100 ; i++) {
//                Book bookA = new Book(fakeData.book().author(),
//                        fakeData.book().title(),
//                        fakeData.code().isbn13(),
//                        new Random().nextInt(1900, 2025));
//
//                book.save(bookA);
//            }
//
//            logger.info("Data saved to DB successfully!!! <---");
//
//        };
//    }

}
