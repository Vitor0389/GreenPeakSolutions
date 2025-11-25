package com.GreenPeak.repository;

import com.GreenPeak.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<UUID, User> storage = new ConcurrentHashMap<>();

    public boolean existsById(UUID id) {
        return storage.containsKey(id);
    }

    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.ensureId();
        }
        storage.put(user.getId(), user);
        return user;
    }

    public void delete(User user) {
        if (user != null && user.getId() != null) {
            storage.remove(user.getId());
        }
    }

    public void deleteAll() {
        storage.clear();
    }
}