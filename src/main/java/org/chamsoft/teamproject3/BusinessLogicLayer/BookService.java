package org.chamsoft.teamproject3.BusinessLogicLayer;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.MapperLayer.BookMapper;
import org.chamsoft.teamproject3.PresentationLayer.BookRequestModel;
import org.chamsoft.teamproject3.PresentationLayer.BookResponseModel;
import org.chamsoft.teamproject3.Utilities.InvalidBookDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
    }

    public List<BookResponseModel> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseModel> result = new ArrayList<>();
        for (Book book : books) {
            result.add(bookMapper.toResponse(book));
        }
        return result;
    }

    @Transactional
    public BookResponseModel createBook(BookRequestModel bookRequest) {
        if (bookRequest.getAuthor() == null || bookRequest.getAuthor().getId() == null) {
            throw new InvalidBookDataException("Author ID cannot be null");
        }

        Author author = authorRepository.findById(bookRequest.getAuthor().getId())
                .orElseThrow(() -> new InvalidBookDataException("Author with this id does not exist"));

        Book book = new Book(bookRequest.getBorrower(), author);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }


    @Transactional
    public BookResponseModel updateBook(Long id, BookRequestModel bookRequest) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new InvalidBookDataException("Book with this id does not exist"));

        existingBook.setBorrower(bookRequest.getBorrower());

        Author author = authorRepository.findById(bookRequest.getAuthor().getId())
                .orElseThrow(() -> new InvalidBookDataException("Author with this id does not exist"));
        existingBook.setAuthor(author);

        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toResponse(updatedBook);
    }


    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new InvalidBookDataException("Book with this id does not exist");
        }
        bookRepository.deleteById(id);
    }
}


