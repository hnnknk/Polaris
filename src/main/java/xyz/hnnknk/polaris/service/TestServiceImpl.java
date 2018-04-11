package xyz.hnnknk.polaris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hnnknk.polaris.model.Author;
import xyz.hnnknk.polaris.model.Option;
import xyz.hnnknk.polaris.model.Question;
import xyz.hnnknk.polaris.model.Test;
import xyz.hnnknk.polaris.repository.AuthorRepository;
import xyz.hnnknk.polaris.repository.OptionRepository;
import xyz.hnnknk.polaris.repository.QuestionRepository;
import xyz.hnnknk.polaris.repository.TestRepository;

import java.util.*;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestRepository testRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OptionRepository optionRepository;

    @Override
    public void prepareTest() {
        Author author = new Author("Edward", "Stone", "ed@gmail.com");
        prepareQuestions();
        authorRepository.save(author);
        Test test = new Test();
        test.setName("New test");
        test.setAuthor(author);

        test.setQuestions(questionRepository.findAll());

        testRepository.save(test);

        for (Test t : testRepository.findByAuthor_Name("Edward")) {
            System.out.println(t);
            System.out.println("question is:" + t.getQuestions().get(0).getBody());
            for (Option option : t.getQuestions().get(0).getOptions()) {
                System.out.println(option.getBody());
            }
            System.out.println("And answer is: ");
            for (Option option : t.getQuestions().get(0).getOptions()) {
                if(option.isAnswer()) {
                    System.out.println(option.getBody());
                }
            }
        }
    }

    public void prepareQuestions() {
        Question question = new Question("What is a superclass of all classes?", true);
        Option op1 = new Option("Super", false);
        Option op2 = new Option("Object", true);
        Option op3 = new Option("SuperClass", false);
        Option op4 = new Option("Java doesn't have a superclass", false);

        List<Option> options = new ArrayList<>();
        options.add(op1);
        options.add(op2);
        options.add(op3);
        options.add(op4);
        question.setOptions(options);
        questionRepository.save(question);
    }
}
