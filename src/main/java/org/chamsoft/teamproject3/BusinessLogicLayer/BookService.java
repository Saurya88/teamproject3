package org.chamsoft.teamproject3.BusinessLogicLayer;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.PresentationLayer.*;
import org.chamsoft.teamproject3.MapperLayer.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<BookResponseModel> getCars() {
        List<Book> books = this.bookRepository.findAll();
        // map the list of cars to list of CarResponseModel
        List<BookResponseModel> bookResponseModels = new ArrayList<>();
        for (Book book : books) {
            bookResponseModels.add(this.bookMapper.toResponse(book));

        }
        return bookResponseModels;
    }

    public void deleteBook(Long id) {
        long idLong = id;
        this.bookRepository.deleteBookById(id);
    }
}
