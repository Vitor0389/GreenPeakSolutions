package com.GreenPeak.controller;

import com.GreenPeak.model.User;
import com.GreenPeak.model.UserDTO;
import com.GreenPeak.repository.UserRepository;
import com.GreenPeak.service.User.UserDeleteService;
import com.GreenPeak.service.User.UserFindService;
import com.GreenPeak.service.User.UserSaveService;
import com.GreenPeak.service.User.UserUpdateService;
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
    public Optional<User> updateUser(@RequestParam UUID uuid,
                                     @RequestParam(required = false) String email,
                                     @RequestParam(required = false) String password){
        return userUpdateService.update(uuid, email, password);
    }

    @PostMapping("/updateuseremail")
    public Optional<User> updateUserEmail(@RequestParam UUID uuid,
                                          @RequestParam String email){
        return userUpdateService.updateEmail(uuid, email);
    }

    @PostMapping("/updateuserpassword")
    public Optional<User> updateUserPassword(@RequestParam UUID uuid,
                                             @RequestParam String password){
        return userUpdateService.updatePassword(uuid, password);
    }

    @DeleteMapping("/user/{uuid}")
    public void deleteUser(@PathVariable UUID uuid){userDeleteService.delete(uuid);}

    @DeleteMapping("/users")
    public void deleteUsers(){userDeleteService.deleteAll();}
}
