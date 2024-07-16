package com.example.userservice.services;


import com.example.userservice.models.User;
import com.example.userservice.respositories.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Ideally should be an interface
@Service // This is a bean, so we can inject it anywhere we need it.
public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepo userRepository;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder,
                       UserRepo userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }
    public User signUp(String name, String email, String password) {
        //Validation

        //Validation

        User u = new User();
        u.setEmail(email);
        u.setName(name);
        u.setHashedPassword(bCryptPasswordEncoder.encode(password));

        User user = userRepository.save(u);
        return user;
    }
}