package com.jux.myhomebook.Service;

import com.jux.myhomebook.Model.User;
import com.jux.myhomebook.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id){

        return userRepository.findById(id);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser (User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUser (Long id){
        userRepository.deleteById(id);
    }
}