package xyz.hnnknk.polaris.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.hnnknk.polaris.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAll();
    Question save(Question question);
}
