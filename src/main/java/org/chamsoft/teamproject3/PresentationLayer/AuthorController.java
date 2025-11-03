package org.chamsoft.teamproject3.PresentationLayer;

import org.chamsoft.teamproject3.BusinessLogicLayer.AuthorService;
import org.chamsoft.teamproject3.DataAccessLayer.Author;
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
    public List<Author> getAllOwners() {
        return this.authorService.getAllAuthors();
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable String id) {
        try {
            this.authorService.deleteAuthorById(id);
            return ResponseEntity.ok("Author deleted successfully.");
        } catch (InvalidBookDataException ex) {
            // Only return the message, no stack trace
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
