package com.pairlearning.demo.service;


import com.pairlearning.demo.model.User;
import com.pairlearning.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserService() {
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> findAll() {

        return userRepository.findAll();
    }
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
   public User getByPhone (Long phone) {
        return userRepository.findByPhone(phone);

   }
}
