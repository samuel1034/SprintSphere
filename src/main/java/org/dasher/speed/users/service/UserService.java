package org.dasher.speed.users.service;

import org.dasher.speed.project.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll () {
        return userRepository.findAll();
    }
    public List <findAllManagers> findAllManagers () {
        return userRepository.findByIsManagerTrue();
    }
    public User save (User user) {
        return userRepository.save(user);
    }
    public void delete (User user) {
        userRepository.delete(user);
    }

}
