package com.example.bestpratices.resources;

import com.example.bestpratices.exceptions.UserNotFoundException;
import com.example.bestpratices.model.domain.User;
import com.example.bestpratices.resources.dto.UserDTO;
import com.example.bestpratices.services.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if(user == null) {
            throw new UserNotFoundException("id - " + user.getId());
        }

        return new UserDTO();
    }
}
