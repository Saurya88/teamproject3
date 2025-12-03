package org.chamsoft.teamproject3.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chamsoft.teamproject3.DataAccessLayer.Author;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSummary extends Author {
    private Long id;
    private String fName;
    private String lName;
}
