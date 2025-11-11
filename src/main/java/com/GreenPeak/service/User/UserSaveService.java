package com.GreenPeak.service.User;

import com.GreenPeak.model.User;
import com.GreenPeak.model.UserDTO;
import com.GreenPeak.repository.UserRepository;
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
