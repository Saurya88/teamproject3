package org.chamsoft.teamproject3.PresentationLayer;

import org.chamsoft.teamproject3.BusinessLogicLayer.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Map<String, Object> getBooks() {
        List<BookResponseModel> books = this.bookService.getBooks(  );
        return  Map.of(
                "status", "Success",
                "list of all books", books);
    }


    @DeleteMapping("/books/{id}")
    public Map<String, Object> deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return Map.of("status","success",
                "message","Book deleted successfully",
                "id",id);
    }
}
