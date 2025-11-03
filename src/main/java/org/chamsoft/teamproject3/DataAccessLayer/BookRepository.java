package org.chamsoft.teamproject3.DataAccessLayer;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteBookById(Long id);
    boolean existsByAuthorId(Long authorId);

}
