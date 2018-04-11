package xyz.hnnknk.polaris.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.hnnknk.polaris.model.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByName(String name);
    List<Author> findAll();
    Author save(Author author);
    void deleteByNameAndSecondName(String name, String secondName);

}
