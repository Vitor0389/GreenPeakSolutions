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

    public Optional<User> update(UUID uuid, String name, String email){

        return repo.findById(uuid).map(user -> {
            if (name != null) user.setName(name);
            if (email != null) user.setEmail(email);
            return repo.save(user); // salva e retorna
        });
    }

    public Optional<User> updateName(UUID uuid, String name){
        return repo.findById(uuid).map(user -> {
            if (name != null) user.setName(name);
            return repo.save(user); // salva e retorna
        });
    }

    public Optional<User> updateEmail(UUID uuid, String email){
        return repo.findById(uuid).map(user -> {
            if (email != null) user.setEmail(email);
            return repo.save(user); // salva e retorna
        });
    }
}
