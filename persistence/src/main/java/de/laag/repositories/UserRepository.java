package de.laag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.laag.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
