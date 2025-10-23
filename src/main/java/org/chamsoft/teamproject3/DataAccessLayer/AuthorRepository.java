package org.chamsoft.teamproject3.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String> {
    List<Author> id(Long id);
}
