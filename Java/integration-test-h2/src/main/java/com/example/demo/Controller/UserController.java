package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return this.service.saveOneUser(user);
    }

    @GetMapping("/fetch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User retrieveUser(@PathVariable int id) {
        return this.service.findOneUser(id);
    }

    @GetMapping("/fetchAll")
    @ResponseStatus(HttpStatus.OK)
    public List<User> retrieveUsers() {
        return this.service.findAllUser();
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneUser(@PathVariable("id") int userId) {
        this.service.deleteOneUser(userId);
    }
}
