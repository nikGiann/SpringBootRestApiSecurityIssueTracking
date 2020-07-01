package com.nikgian.controller;

import com.nikgian.model.User;
import com.nikgian.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User theUser) {

        theUser.setUid(0);

        userService.save(theUser);

        return theUser;
    }

}
