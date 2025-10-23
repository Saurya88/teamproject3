package org.chamsoft.teamproject3.PresentationLayer;

import org.chamsoft.teamproject3.BusinessLogicLayer.AuthorService;
import org.chamsoft.teamproject3.DataAccessLayer.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    private final AuthorService AuthorService;

    public AuthorController(AuthorService ownerService) {
        this.AuthorService = ownerService;
    }

    @GetMapping("/authors")
    public List<Author> getAllOwners() {
        return this.AuthorService.getAllAuthors();
    }

    @DeleteMapping("/authors/{id}")
    public void deleteOwner(@PathVariable String id) {
        this.AuthorService.deleteAuthorById(id);
    }
}
