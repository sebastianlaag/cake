package de.laag.config;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of users
            repository.save(new User("Jack", BCrypt.hashpw("Bauer", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("Chloe", BCrypt.hashpw("O'Brian", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("Kim", BCrypt.hashpw("Bauer", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("David", BCrypt.hashpw("Palmer", BCrypt.gensalt(Constants.LOG_ROUNDS))));
            repository.save(new User("Michelle", BCrypt.hashpw("Dessler", BCrypt.gensalt(Constants.LOG_ROUNDS))));

            // fetch all users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual user by ID
            User user = repository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");
        };
    }

}
