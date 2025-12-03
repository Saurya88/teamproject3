package org.chamsoft.teamproject3;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class TeamProject3Application implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public TeamProject3Application(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(TeamProject3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(TeamProject3Application.class, args);
        logger.info("Application started");
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Existing authors
        Author author1 = new Author("John", "Johnson");
        Author author2 = new Author("Mary", "Robinson");

        // New authors
        Author author3 = new Author("Eric", "Ionascu");
        Author author4 = new Author("Sarah", "Miller");
        Author author5 = new Author("David", "Thompson");
        Author author6 = new Author("Emily", "Carter");

        authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5, author6));

        bookRepository.save(new Book("Alice", author1));
        bookRepository.save(new Book("Bob", author2));
        bookRepository.save(new Book("Charlie", author1));

        bookRepository.save(new Book("The Silent Forest", author3));
        bookRepository.save(new Book("Ocean of Dreams", author4));
        bookRepository.save(new Book("Final Horizon", author5));
        bookRepository.save(new Book("Shadows of Time", author6));
        bookRepository.save(new Book("Broken Symphony", author3));
        bookRepository.save(new Book("City of Emberlight", author4));
        bookRepository.save(new Book("Moonrise Valley", author5));
        bookRepository.save(new Book("Echoes of Dawn", author6));

        for (Book book : this.bookRepository.findAll()) {
            logger.info("title: {}, author: {} {}",
                    book.getAuthor().getFName(),
                    book.getAuthor().getLName());
        }
    }

}
