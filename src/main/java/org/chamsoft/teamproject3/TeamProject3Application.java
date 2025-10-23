package org.chamsoft.teamproject3;

import org.chamsoft.teamproject3.DataAccessLayer.Book;
import org.chamsoft.teamproject3.DataAccessLayer.BookRepository;
import org.chamsoft.teamproject3.DataAccessLayer.Author;
import org.chamsoft.teamproject3.DataAccessLayer.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    public void run(String... args) throws Exception {

        // --- Create authors ---
        Author author1 = new Author("John", "Johnson");

        Author author2 = new Author("Mary", "Robinson");

        authorRepository.saveAll(Arrays.asList(author1, author2));

        // --- Create books ---
        this.bookRepository.save(new Book("Alice",author1));
        this.bookRepository.save(new Book("Bob",author2));
        this.bookRepository.save(new Book("Charlie",author1));

        // --- Fetch all books and log ---
        for (Book book : this.bookRepository.findAll()) {
            logger.info("title: {}, author: {} {}",
                    book.getAuthor().getFName(),
                    book.getAuthor().getLName());
        }
    }
}
