package com.aprendizado.service;

import com.aprendizado.model.User;
import com.aprendizado.model.UserDTO;
import com.aprendizado.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSaveService {

    private UserRepository repo;

    public UserSaveService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        return repo.save(user);
    }
}
