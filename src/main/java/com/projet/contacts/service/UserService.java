package com.projet.contacts.service;

import com.projet.contacts.dto.UserDTO;
import com.projet.contacts.entity.User;
import com.projet.contacts.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void register(UserDTO userDTO) {
        this.userRepository.save(this.toUser(userDTO));
    }

    public User toUser(UserDTO userDTO) {
        User u = new User();
        u.setEmail(userDTO.getEmail());
        u.setUsername(userDTO.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        u.setPassword(encodedPassword);
        return u;
    }
}