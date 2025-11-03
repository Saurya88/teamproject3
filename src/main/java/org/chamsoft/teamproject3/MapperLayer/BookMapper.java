package org.chamsoft.teamproject3.MapperLayer;

import org.chamsoft.teamproject3.DataAccessLayer.*;
import org.chamsoft.teamproject3.PresentationLayer.*;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorRepository authorRepository;

    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

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
                book.getId(),
                book.getBorrower(),
                author
        );
    }

    public Book fromRequestModelToBookEntity(BookResponseModel bookResponseModel) {
        Book newBook = new Book();

        newBook.setAuthor(bookResponseModel.getAuthor());


        if (bookResponseModel.getAuthor() != null) {
            Long authorId = bookResponseModel.getAuthor().getId();  // get author ID from DTO
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new IllegalArgumentException("Author not found"));
            newBook.setAuthor(author);  // attach managed entity
        }

        return newBook;
    }
}
