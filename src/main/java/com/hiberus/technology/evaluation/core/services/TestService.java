package com.hiberus.technology.evaluation.core.services;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.services.models.ExampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestService {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world from REST service";
    }

    @RequestMapping("/goodbye")
    public ExampleModel goodbye() {
//        return ExampleModel.of(1,"test /model", LocalDate.now());
        return null;
    }

    public List<ExampleModel> findUsers() {
        return null;
    }
}
