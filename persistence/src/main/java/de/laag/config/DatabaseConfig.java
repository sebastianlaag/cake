package de.laag.config;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.laag.Constants;
import de.laag.entities.User;
import de.laag.repositories.UserRepository;

@EntityScan(basePackages = Constants.BASE_PACKAGE)
@EnableJpaRepositories(basePackages = Constants.BASE_PACKAGE)
public class DatabaseConfig {

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of users
            repository.save(new User("Chloe", BCrypt.hashpw("O'Brian", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("Kim", BCrypt.hashpw("Bauer", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("David", BCrypt.hashpw("Palmer", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("Michelle", BCrypt.hashpw("Dessler", BCrypt.gensalt(Constants.LOG_ROUNDS))));

            for(User user : repository.findAll()) {
                System.out.println(user.getPasswordHash());
            }
        };
    }

}
