package org.chamsoft.teamproject3.PresentationLayer;

import org.chamsoft.teamproject3.BusinessLogicLayer.BookService;
import org.chamsoft.teamproject3.Utilities.InvalidBookDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Map<String, Object> getBooks() {
        List<BookResponseModel> books = bookService.getBooks();
        return Map.of("status", "success", "books", books);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequestModel bookRequest) {
        try {
            BookResponseModel createdBook = bookService.createBook(bookRequest);
            return ResponseEntity.ok(createdBook); // same as before, but now exceptions are caught
        } catch (InvalidBookDataException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookRequestModel bookRequest) {
        try {
            BookResponseModel updatedBook = bookService.updateBook(id, bookRequest);
            return ResponseEntity.ok(updatedBook);
        } catch (InvalidBookDataException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public Map<String, Object> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return Map.of(
                "status", "success",
                "message", "Book deleted successfully",
                "id", id
        );
    }
}
