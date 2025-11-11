package com.GreenPeak.service;

import com.GreenPeak.model.User;
import com.GreenPeak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserDeleteService {

    private UserRepository repo;

    public UserDeleteService(UserRepository repo) {
        this.repo = repo;
    }

    public void delete(UUID uuid){

        if(repo.existsById(uuid)){
           Optional<User> user = repo.findById(uuid);

            user.ifPresent(value -> repo.delete(value));

        }
    }

    public void deleteAll(){
        repo.deleteAll();
    }
}
