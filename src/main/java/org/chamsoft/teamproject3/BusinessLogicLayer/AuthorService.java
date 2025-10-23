package org.chamsoft.teamproject3.BusinessLogicLayer;
import org.springframework.stereotype.Service;


import org.chamsoft.teamproject3.Utilities.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.PresentationLayer.*;
import org.chamsoft.teamproject3.MapperLayer.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List getAllAuthors() {
        return this.authorRepository.findAll();
    }


    public void deleteAuthorById(String id) {
        long longId = Long.parseLong(id);
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new InvalidBookDataException("Author with id: " + longId + " not found."));

        authorRepository.delete(author);
    }
}
