package com.example.bestpratices.resources;

import com.example.bestpratices.exceptions.UserNotFoundException;
import com.example.bestpratices.model.domain.User;
import com.example.bestpratices.resources.dto.UserDTO;
import com.example.bestpratices.services.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RequestMapping
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public Resource<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if(user == null) {
            throw new UserNotFoundException("id - " + user.getId());
        }

        Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).getUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }
}
