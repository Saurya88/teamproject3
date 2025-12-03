package org.chamsoft.teamproject3.MapperLayer;

import org.chamsoft.teamproject3.DataAccessLayer.Book;
import org.chamsoft.teamproject3.PresentationLayer.AuthorSummary;
import org.chamsoft.teamproject3.PresentationLayer.BookResponseModel;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponseModel toResponse(Book book) {
        AuthorSummary authorSummary = null;

        if (book.getAuthor() != null) {
            authorSummary = new AuthorSummary(
                    book.getAuthor().getId(),
                    book.getAuthor().getFName(),
                    book.getAuthor().getLName()
            );
        }

        return new BookResponseModel(
                book.getId(),
                book.getBorrower(),
                authorSummary
        );
    }
}
