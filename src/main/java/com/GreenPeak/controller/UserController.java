package com.aprendizado.controller;

import com.aprendizado.model.User;
import com.aprendizado.model.UserDTO;
import com.aprendizado.repository.UserRepository;
import com.aprendizado.service.UserDeleteService;
import com.aprendizado.service.UserFindService;
import com.aprendizado.service.UserSaveService;
import com.aprendizado.service.UserUpdateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserSaveService userSaveService;
    private final UserFindService userFindService;
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;

    private UserRepository repo;


    public UserController(UserRepository repo, UserSaveService userSaveService, UserFindService userFindService, UserUpdateService update, UserUpdateService userUpdateService, UserDeleteService userDeleteService) {
        this.repo = repo;
        this.userSaveService = userSaveService;
        this.userFindService = userFindService;
        this.userUpdateService = userUpdateService;
        this.userDeleteService = userDeleteService;
    }



    @GetMapping("/user/{uuid}")
    public Optional<User> getUser(@PathVariable UUID uuid){
        return userFindService.findById(uuid);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userFindService.findAll();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody UserDTO userDTO){
        return userSaveService.save(userDTO);
    }

    @PostMapping("/updateuser")
    public Optional<User> updateUser(@RequestBody UUID uuid, String name, String email){return userUpdateService.update(uuid, name, email);}

    @PostMapping("/updateusername")
    public Optional<User> updateUserName(@RequestBody UUID uuid, String name){return userUpdateService.updateName(uuid, name);}

    @PostMapping("/updateuseremail")
    public Optional<User> updateUserEmail(@RequestBody UUID uuid, String email){return userUpdateService.updateEmail(uuid, email);}

    @DeleteMapping("/user/{uuid}")
    public void deleteUser(@PathVariable UUID uuid){userDeleteService.delete(uuid);}

    @DeleteMapping("/users")
    public void deleteUsers(){userDeleteService.deleteAll();}





}
