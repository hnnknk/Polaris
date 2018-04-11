package xyz.hnnknk.polaris.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.hnnknk.polaris.model.Test;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

    Test save(Test test);
    List<Test> findAll();
    List<Test> findByAuthor_Name(String name);
}
