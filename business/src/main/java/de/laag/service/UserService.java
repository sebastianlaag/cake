package de.laag.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.laag.Constants;
import de.laag.entities.User;
import de.laag.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public void saveUser(String login, String passwordPlain) {
        final String hashpw = BCrypt.hashpw(passwordPlain, BCrypt.gensalt(Constants.LOG_ROUNDS));
        User saveUser = new User(login, hashpw);
        userRepository.save(saveUser);
    }
}
