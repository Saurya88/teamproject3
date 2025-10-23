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

    // Simple GET endpoint
    @GetMapping("/books")
    public Map<String, Object> getCars() {
        List<BookResponseModel> cars = this.bookService.getCars(  );
        return  Map.of(
                "status", "Success",
                "list of all cars", cars);
    }


    @DeleteMapping("/books/{id}")
    //A REGARDER SI ERREUR
    public Map<String, Object> deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return Map.of("status","success",
                "message","Car deleted successfully",
                "id",id);
    }
}
