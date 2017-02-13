package de.laag;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import de.laag.entities.User;
import de.laag.repositories.UserRepository;
import de.laag.service.LoginService;

public class LoginServiceTest {

    private LoginService loginService;

    private UserRepository userRepository;

    private static final String USER_NAME = "Jack";
    private static final String PASSWORD_PLAIN = "Bauer";

    @Before
    public void before() {
        userRepository = mock(UserRepository.class);
        loginService = new LoginService(userRepository);

        final String hashpw = BCrypt.hashpw(PASSWORD_PLAIN, BCrypt.gensalt(Constants.LOG_ROUNDS));
        when(userRepository.findByLogin(USER_NAME)).thenReturn(new User(USER_NAME, hashpw));
    }

    @Test
    public void login() {
        final User login = loginService.login(USER_NAME, PASSWORD_PLAIN);
        assertThat(login.getLogin()).isEqualTo(USER_NAME);
    }

}
