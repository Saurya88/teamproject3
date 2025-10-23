package org.chamsoft.teamproject3.MapperLayer;

import org.chamsoft.teamproject3.DataAccessLayer.Author;
import org.chamsoft.teamproject3.PresentationLayer.AuthorResponseModel;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorResponseModel toResponse(Author author) {
        return new AuthorResponseModel(
                author.getFName(),
                author.getLName()
        );
    }
}
