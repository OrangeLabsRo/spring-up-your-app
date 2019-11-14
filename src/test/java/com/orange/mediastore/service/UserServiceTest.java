package com.orange.mediastore.service;

import com.orange.mediastore.exceptions.UserAlreadyExistsException;
import com.orange.mediastore.model.User;
import com.orange.mediastore.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

import static com.orange.mediastore.TestUtils.createUser;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void whenTryToRegisterAnExistingUser_ThenThrowException() {
        User user = createUser("Maria", "Test@123!");

        when(userRepository.findByUsername(any(String.class))).thenReturn(user);

        expectedException.expect(UserAlreadyExistsException.class);
        expectedException.expectMessage("Username already in use: Maria");

        userService.register(user);

        verifyZeroInteractions(passwordEncoder);
        verify(userRepository, times(0)).save(user);
    }

    @Test
    public void whenTryToRegisterAnNewUser_ThenSaveItInDb() {
        User user = createUser("Alex", "Test@123!");
        when(userRepository.findByUsername(any(String.class))).thenReturn(null);
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");

        userService.register(user);

        verify(userRepository).save(user);

        Assertions.assertThat(user).extracting("password")
                .contains("encodedPassword");
    }

}
