package org.chamsoft.teamproject3.DataAccessLayer;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    void deleteBookById(Long id);
}
