package org.chamsoft.teamproject3.BusinessLogicLayer;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.PresentationLayer.*;
import org.chamsoft.teamproject3.MapperLayer.*;
import org.chamsoft.teamproject3.Utilities.InvalidBookDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookResponseModel> getBooks() {
        List<Book> books = this.bookRepository.findAll();

        List<BookResponseModel> bookResponseModels = new ArrayList<>();
        for (Book book : books) {
            bookResponseModels.add(this.bookMapper.toResponse(book));

        }
        return bookResponseModels;
    }

    @Transactional
    public void deleteBook(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new InvalidBookDataException("Book with this id does not exist");
        }
        this.bookRepository.deleteBookById(id);
    }
}
