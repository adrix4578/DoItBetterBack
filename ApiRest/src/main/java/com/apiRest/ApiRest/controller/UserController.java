package com.apiRest.ApiRest.controller;

import com.apiRest.ApiRest.RoutineService;
import com.apiRest.ApiRest.UserService;
import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.model.User;
import com.apiRest.ApiRest.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoutineService routineService;

    @PostMapping
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}/routines")
    public List<Routine> getRoutineByUserId(@PathVariable("id") Long id){
        User tempUser = userService.getUserById(id);
        return routineService.getRoutineByUserId(tempUser);
    }

    @GetMapping("{id}")
    public User searchUserByID(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserByID(@PathVariable("id") Long id){
         userService.deleteUser(id);
    }

}
