package org.chamsoft.teamproject3.PresentationLayer;

import lombok.Getter;
import org.chamsoft.teamproject3.DataAccessLayer.Author;

@Getter
public class BookResponseModel {
        private Long id;
        private String borrower;
        private Author author;

    public BookResponseModel(String borrower, Author author) {
        this.borrower = borrower;
        this.author = author;
    }
}




