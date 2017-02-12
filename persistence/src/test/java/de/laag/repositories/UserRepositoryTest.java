package de.laag.repositories;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import de.laag.config.DatabaseConfig;
import de.laag.entities.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static final String LOGIN = "test";

    @Test
    public void saveAndFindOne() {
        final User test = userRepository.save(new User(LOGIN, "test"));
        final User user = userRepository.findOne(test.getId());
        assertThat(user.getLogin()).isEqualTo(LOGIN);
    }

    @Test
    public void saveAndFindByLogin() {
        userRepository.save(new User(LOGIN, "test"));
        final User user = userRepository.findByLogin(LOGIN);
        assertThat(user.getLogin()).isEqualTo(LOGIN);
    }
}
