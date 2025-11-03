package org.chamsoft.teamproject3.PresentationLayer;

import lombok.Getter;
import org.chamsoft.teamproject3.DataAccessLayer.Author;

@Getter
public class BookResponseModel {
        private Long id;
        private String borrower;
        private Author author;

    public BookResponseModel(Long id, String borrower, Author author) {
        this.id = id;
        this.borrower = borrower;
        this.author = author;
    }
}




