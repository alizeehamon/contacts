package com.projet.contacts.service;

import com.projet.contacts.dto.UserDTO;
import com.projet.contacts.entity.User;
import com.projet.contacts.repository.UserRepository;
import com.projet.contacts.uploadingfile.service.FileSystemStorageService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        u.setFirstName(userDTO.getFirstName());
        u.setLastName(userDTO.getLastName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        u.setPassword(encodedPassword);
        u.setImageUrl(userDTO.getImage());
        return u;
    }

    public UserDTO toDTO(User user) {
        UserDTO u = new UserDTO();
        u.setEmail(user.getEmail());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setImage(user.getImageUrl());
        return u;
    }

    public UserDTO findUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        UserDTO userDTO = toDTO(user);
        return userDTO;
    }

    public void edit(UserDTO userDTO, String email) {
        User user = this.userRepository.findByEmail(email);
        if(user != null){
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(encodedPassword);
            user.setImageUrl(userDTO.getImage());
            this.userRepository.save(user);
        }

    }
}