package com.ticketApp.ticketApp.controller;


import com.ticketApp.ticketApp.dto.TicketDTO;
import com.ticketApp.ticketApp.dto.UserDTO;
import com.ticketApp.ticketApp.entity.UserEntity;
import com.ticketApp.ticketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Integer id) {
        return userService.getUserByID(id);
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) throws Exception {
        return userService.saveUser(user);
    }
}
