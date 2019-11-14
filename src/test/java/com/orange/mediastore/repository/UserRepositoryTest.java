package com.orange.mediastore.repository;

import com.orange.mediastore.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.orange.mediastore.TestUtils.createUser;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {
    private final Set<String> MEDIAS = new HashSet<>(Arrays.asList("id1", "id2"));;
    private User USER = createUser("Alex", "Test@123!");

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.save(USER);
    }

    @After
    public void tearDown() throws Exception {
        userRepository.delete(USER);
    }

    @Test
    public void givenAnUser_whenSearchForHim_thenFindUserInDB() {
        User alex = userRepository.findByUsername("Alex");

        assertThat(alex).isNotNull();
        assertThat(alex).extracting("username", "password","favouriteMovieIds")
                .contains("Alex", "Test@123!", MEDIAS);

    }
}
