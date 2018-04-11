package xyz.hnnknk.polaris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.hnnknk.polaris.model.Author;
import xyz.hnnknk.polaris.model.Test;
import xyz.hnnknk.polaris.repository.AuthorRepository;
import xyz.hnnknk.polaris.repository.TestRepository;
import xyz.hnnknk.polaris.service.TestService;

@Controller
public class IndexController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        testService.prepareTest();
        return "index";
    }
}
