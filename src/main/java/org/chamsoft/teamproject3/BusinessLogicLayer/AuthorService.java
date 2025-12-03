package org.chamsoft.teamproject3.BusinessLogicLayer;

import org.springframework.stereotype.Service;
import org.chamsoft.teamproject3.Utilities.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }


    public Author createAuthor(Author author) {
        if (author.getFName() == null || author.getFName().isBlank()) {
            throw new InvalidBookDataException("Author first name cannot be empty.");
        }
        if (author.getLName() == null || author.getLName().isBlank()) {
            throw new InvalidBookDataException("Author last name cannot be empty.");
        }

        return authorRepository.save(author);
    }


    public Author updateAuthor(String id, Author updatedAuthor) {
        long longId = Long.parseLong(id);

        Author existing = authorRepository.findById(longId)
                .orElseThrow(() ->
                        new AuthorNotFoundException("Author with id: " + longId + " not found.")
                );

        if (updatedAuthor.getFName() != null) {
            existing.setFName(updatedAuthor.getFName());
        }
        if (updatedAuthor.getLName() != null) {
            existing.setLName(updatedAuthor.getLName());
        }

        return authorRepository.save(existing);
    }


    public void deleteAuthorById(String id) {
        long longId = Long.parseLong(id);

        Author author = authorRepository.findById(longId)
                .orElseThrow(() ->
                        new AuthorNotFoundException("Author with id: " + longId + " not found.")
                );

        boolean hasBooks = bookRepository.existsByAuthorId(longId);

        if (hasBooks) {
            throw new InvalidBookDataException("Cannot delete author because they have books.");
        }

        authorRepository.delete(author);
    }
}


