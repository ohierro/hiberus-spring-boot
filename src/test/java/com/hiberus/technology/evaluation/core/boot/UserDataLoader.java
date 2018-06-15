package com.hiberus.technology.evaluation.core.boot;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements ApplicationRunner{

    private UserRepository userRepository;

    @Autowired
    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {

        UserEntity entity = new UserEntity();
        entity.setName("Foo");
        entity.setSurname("Bar");
        entity.setPasswd("1234");
        entity.setEmail("test@hiberus.com");

        userRepository.save(entity);
    }
}
