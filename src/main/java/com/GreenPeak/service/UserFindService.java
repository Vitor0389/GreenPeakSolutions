package com.GreenPeak.service;

import com.GreenPeak.model.User;
import com.GreenPeak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserFindService {

    private UserRepository repo;

    public UserFindService(UserRepository repo) {
        this.repo = repo;
    }
    public Optional<User> findById(UUID uuid){

       if (repo.existsById(uuid)){
           return repo.findById(uuid);
       }

       return Optional.empty();
    }


    public List<User> findAll(){

        return repo.findAll();
    }
}
