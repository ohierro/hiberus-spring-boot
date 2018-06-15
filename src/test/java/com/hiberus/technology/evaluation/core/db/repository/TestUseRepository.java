package com.hiberus.technology.evaluation.core.db.repository;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.impl.UserProviderImpl;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
//@AutoconfigureTestDatabase
public class TestUseRepository {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    private ModelMapper mapper;

    @Before
    public void setUp() {
        mapper = new ModelMapper();
    }

    @Test
    public void testFindByEmail() {
        UserEntity user = new UserEntity();
        user.setName("Foo");
        user.setSurname("Bar");
        user.setNif("11111111H");
        user.setEmail("foo.bar@hiberus.com");
        entityManager.persist(user);

        UserDto userDto = new UserDto();
        mapper.map(user, userDto);

        UserEntity dbUser = repository.findByEmail("foo.bar@hiberus.com");

        assertEquals(user.getName(), dbUser.getName());
        assertEquals(user.getNif(), dbUser.getNif());
        assertEquals(user.getSurname(), dbUser.getSurname());
    }

    @Test
    public void testFindByNonExistentEmail() {
        UserEntity user = new UserEntity();
        user.setName("Foo");
        user.setSurname("Bar");
        user.setNif("11111111H");
        user.setEmail("foo.bar@hiberus.com");
        entityManager.persist(user);

        UserDto userDto = new UserDto();
        mapper.map(user, userDto);

        UserEntity dbUser = repository.findByEmail("fake@hiberus.com");

        assertNull(dbUser);
    }
}
