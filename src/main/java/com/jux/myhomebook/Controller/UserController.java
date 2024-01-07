package com.jux.myhomebook.Controller;

import com.jux.myhomebook.Model.User;
import com.jux.myhomebook.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }


    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> u = userService.getUser(id);
        if (u.isPresent()) {
            User currentUser = u.get();

            String login = user.getLogin();
            if (login != null) {
                currentUser.setLogin(login);
            }

            String firstName = user.getFirstName();
            if (firstName != null) {
                currentUser.setFirstName(firstName);
            }

            String lastName = user.getLastName();
            if (lastName != null) {
                currentUser.setLastName(lastName);
            }

            String password = user.getPassword();
            if (password != null) {
                currentUser.setPassword(password);
            }
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
