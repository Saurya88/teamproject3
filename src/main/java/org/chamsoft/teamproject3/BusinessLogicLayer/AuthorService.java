package org.chamsoft.teamproject3.BusinessLogicLayer;
import org.springframework.stereotype.Service;
import org.chamsoft.teamproject3.Utilities.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import java.util.List;

@Service public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    public void deleteAuthorById(String id) {
        long longId = Long.parseLong(id);

        Author author = authorRepository.findById(longId)
                .orElseThrow(() -> new InvalidBookDataException("Author with id: " + longId + " not found."));

        boolean hasBooks = bookRepository.existsByAuthorId(longId);// <-- use a repository method

        if (hasBooks) {
            throw new InvalidBookDataException("Cannot delete author because they have books.");
        }

        authorRepository.delete(author);
    }
}