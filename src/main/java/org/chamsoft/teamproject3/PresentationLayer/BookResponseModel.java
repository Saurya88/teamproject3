package org.chamsoft.teamproject3.PresentationLayer;

import lombok.Getter;

@Getter
public class BookResponseModel {
    private Long id;
    private String borrower;
    private AuthorSummary author;

    public BookResponseModel(Long id, String borrower, AuthorSummary author) {
        this.id = id;
        this.borrower = borrower;
        this.author = author;
    }
}
