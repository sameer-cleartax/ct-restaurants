package com.restaurants.restaurants;

import com.restaurants.restaurants.entities.User;
import com.restaurants.restaurants.enums.Role;
import com.restaurants.restaurants.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
public class UserRepositoryTest {
    @Autowired private UserRepository user;

    @Test
    void whenSaved_thenFindsByName() {
    }
}
