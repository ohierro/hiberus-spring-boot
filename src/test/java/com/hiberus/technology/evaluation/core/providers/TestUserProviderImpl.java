package com.hiberus.technology.evaluation.core.providers;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.impl.UserProviderImpl;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserProviderImpl {

    private UserProviderImpl userProviderImpl;

    @Mock
    private UserRepository repository;

    @Before
    public void setUp() {
//        userProviderImpl = new UserProviderImpl(repository, new ModelMapper());
    }

    @Test
    public void testFindByEmail() {
        UserEntity user = new UserEntity();
        user.setName("Foo");
        user.setSurname("Bar");
        user.setNif("11111111H");
        user.setEmail("foo.bar@hiberus.com");

        when(repository.findAll()).thenReturn(Arrays.asList(new UserEntity[] {user}));


        UserEntity dbUser = userProviderImpl.findByEmail("foo.bar@hiberus.com");

        assertEquals(user.getName(), dbUser.getName());
        assertEquals(user.getSurname(), dbUser.getSurname());
        assertEquals(user.getNif(), dbUser.getNif());
    }

    @Test
    public void testFindByNonExistentEmail() {
        UserEntity user = new UserEntity();
        user.setName("Foo");
        user.setSurname("Bar");
        user.setNif("11111111H");
        user.setEmail("foo.bar@hiberus.com");

        when(repository.findAll()).thenReturn(Arrays.asList(new UserEntity[] {user}));

        UserEntity dbUser = userProviderImpl.findByEmail("fake@hiberus.com");

        assertNull(dbUser);
    }
}
