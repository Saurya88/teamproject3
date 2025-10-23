package org.chamsoft.teamproject3.MapperLayer;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.PresentationLayer.*;
import org.chamsoft.teamproject3.MapperLayer.*;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorRepository authorRepository;

    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // this method maps a book object into a BookResponseModel DTO
    public BookResponseModel toResponse(Book book) {
        Author author = book.getAuthor(); // Get the Author object
        AuthorSummary authorSummary;

        if (author == null) {
            authorSummary = null;
        } else {
            authorSummary = new AuthorSummary(
                    author.getId(),
                    author.getFName(),
                    author.getLName()
            );
        }

        return new BookResponseModel(
                book.getBorrower(),
                author
        );
    }

//    private String id;
//    private String borrower;
//    private AuthorSummary author;


    public Book fromRequestModelToBookEntity(BookResponseModel bookResponseModel) {
        Book newBook = new Book();

        // Map fields from DTO to entity
        newBook.setAuthor(bookResponseModel.getAuthor());


        // --- AUTHOR HANDLING ---
        if (bookResponseModel.getAuthor() != null) {
            String authorId = String.valueOf(bookResponseModel.getAuthor().getId());  // get author ID from DTO
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new IllegalArgumentException("Author not found"));
            newBook.setAuthor(author);  // attach managed entity
        }

        return newBook;
    }
}
