package com.goldenlibrary.mgtsystem.controllers;


import com.goldenlibrary.mgtsystem.models.User;
import com.goldenlibrary.mgtsystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Iterable<User> user(){
        return userRepository.findAll();
    }

}