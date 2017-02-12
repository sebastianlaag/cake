package de.laag;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import de.laag.config.BusinessConfig;
import de.laag.entities.User;
import de.laag.repositories.CakeRepository;
import de.laag.repositories.UserRepository;
import de.laag.service.LoginService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BusinessConfig.class)
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private CakeRepository cakeRepository;

    private static final String USER_NAME = "Jack";

    private static final String PASSWORD_PLAIN = "Bauer";

    @Before
    public void before() {
        final String hashpw = BCrypt.hashpw(PASSWORD_PLAIN, BCrypt.gensalt(Constants.LOG_ROUNDS));
        when(userRepository.findByLogin(USER_NAME)).thenReturn(new User(USER_NAME, hashpw));
    }

    @Test
    public void login() {
        final User login = loginService.login(USER_NAME, PASSWORD_PLAIN);
        assertThat(login.getLogin()).isEqualTo(USER_NAME);
    }

}
