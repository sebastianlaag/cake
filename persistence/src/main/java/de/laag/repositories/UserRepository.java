package de.laag.repositories;

import org.springframework.data.repository.CrudRepository;

import de.laag.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
