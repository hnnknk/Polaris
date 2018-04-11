package xyz.hnnknk.polaris.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.hnnknk.polaris.model.Option;

import java.util.List;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {

    List<Option> findAll();
    Option save(Option option);
}
