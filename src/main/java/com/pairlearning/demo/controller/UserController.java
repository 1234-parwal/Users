package com.pairlearning.demo.controller;

import com.pairlearning.demo.model.User;
import com.pairlearning.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pairlearning.demo.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("users")
    public List<User> getAllUser() {

        return userService.findAll();
    }

   @GetMapping("users/ap/{id}")
   public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userId)
       throws ResourceNotFoundException {
        User user = userService.getById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found with this id: "+ userId));
        return ResponseEntity.ok().body(user);
   }

    @PostMapping("users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("users/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable(value="phone") Long phone)
    {
        User user = userService.getByPhone(phone);
        return ResponseEntity.ok().body(user);
    }

}
