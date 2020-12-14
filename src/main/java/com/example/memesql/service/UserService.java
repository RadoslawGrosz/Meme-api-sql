package com.example.memesql.service;

import com.example.memesql.models.User;
import com.example.memesql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public User logIn(String token) throws UsernameNotFoundException {

        String base64Credentials = token.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        // credentials = username:password
        final String username = credentials.split(":", 2)[0];

        Optional<User> optionalUser = userRepo.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new User(
                    user.getId(),
                    user.getUsername(),
                    "",
                    user.getRole()
            );
        } else {
            return new User();
        }

//        User foundUser;
//        return optionalUser.ifPresentOrElse(
//                user -> {
//                    return new User(
//                            user.getId(),
//                            user.getUsername(),
//                            "",
//                            user.getRole()
//                    );
//                },
//                () -> {
//                    throw new UsernameNotFoundException("User not found");
//                });

//        if (foundUser == null) {
//            throw new UsernameNotFoundException("User not found");
//        }

//        return new User(
//                foundUser.getId(),
//                foundUser.getUsername(),
//                "",
//                foundUser.getRole()
//        );
    }

}

