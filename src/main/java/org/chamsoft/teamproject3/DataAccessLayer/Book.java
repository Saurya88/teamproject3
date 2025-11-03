package org.chamsoft.teamproject3.DataAccessLayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Book_Name")
    private String borrower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_author_id")
    private Author author;


    public Book(String borrower, Author author) {
        this.borrower = borrower;
        this.author = author;

    }
}