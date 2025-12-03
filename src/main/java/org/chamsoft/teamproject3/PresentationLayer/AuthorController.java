package org.chamsoft.teamproject3.PresentationLayer;

import org.chamsoft.teamproject3.BusinessLogicLayer.AuthorService;
import org.chamsoft.teamproject3.DataAccessLayer.Author;
import org.chamsoft.teamproject3.Utilities.AuthorNotFoundException;
import org.chamsoft.teamproject3.Utilities.InvalidBookDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService ownerService) {
        this.authorService = ownerService;
    }


    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequestModel authorRequest) {
        try {
            Author author = new Author(authorRequest.getFName(), authorRequest.getLName());
            Author created = authorService.createAuthor(author);
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "author", created
            ));
        } catch (InvalidBookDataException ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "message", ex.getMessage()
            ));
        }
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable String id, @RequestBody AuthorRequestModel authorRequest) {
        try {
            Author updatedAuthor = new Author(authorRequest.getFName(), authorRequest.getLName());
            Author updated = authorService.updateAuthor(id, updatedAuthor);
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "author", updated
            ));
        } catch (AuthorNotFoundException | InvalidBookDataException ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "message", ex.getMessage()
            ));
        }
    }




    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String id) {
        try {
            this.authorService.deleteAuthorById(id);
            return ResponseEntity.ok("Author deleted successfully.");
        } catch (InvalidBookDataException | AuthorNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
