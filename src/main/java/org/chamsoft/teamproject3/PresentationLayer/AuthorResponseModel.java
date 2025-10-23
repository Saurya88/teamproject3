package org.chamsoft.teamproject3.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseModel {
    private String id;
    private String fName, lName;
    private BookSummary book;

    public AuthorResponseModel(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
}
