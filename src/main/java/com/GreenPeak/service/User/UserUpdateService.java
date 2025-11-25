package com.GreenPeak.service.User;

import com.GreenPeak.model.User;
import com.GreenPeak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserUpdateService {

    private UserRepository repo;

    public UserUpdateService(UserRepository repo) {
        this.repo = repo;
    }

    public Optional<User> update(UUID uuid, String email, String password){
        return repo.findById(uuid).map(user -> {
            if (email != null) user.setEmail(email);
            if (password != null) user.setPassword(password);
            return repo.save(user);
        });
    }

    public Optional<User> updateEmail(UUID uuid, String email){
        return repo.findById(uuid).map(user -> {
            if (email != null) user.setEmail(email);
            return repo.save(user);
        });
    }

    public Optional<User> updatePassword(UUID uuid, String password){
        return repo.findById(uuid).map(user -> {
            if (password != null) user.setPassword(password);
            return repo.save(user);
        });
    }
}
